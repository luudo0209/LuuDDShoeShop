package com.luudd.service.serviceImpl;

import com.luudd.entity.Product;
import com.luudd.entity.ProductImage;
import com.luudd.model.dto.ProductDTO;
import com.luudd.model.dto.ProductImageDTO;
import com.luudd.model.mapper.ProductImageMapper;
import com.luudd.model.mapper.ProductMapper;
import com.luudd.model.request.ProductImageRequest;
import com.luudd.repository.IProductImageRepository;
import com.luudd.repository.IProductRepository;
import com.luudd.service.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@Service
public class ProductImageService implements IProductImageService {

    @Autowired
    private IProductImageRepository productImageRepository;

    @Autowired
    private IProductRepository productRepository;

    @Transactional
    @Override
    public ProductImageDTO createProductImage(ProductImageRequest productImageRequest) {
        ProductImage productImage = new ProductImage();
        Date date = new Date();
        try {
            Product product = productRepository.getProductById(productImageRequest.getProductId());
            if (productImageRequest != null && product != null) {
                productImage.setLink(productImageRequest.getLink());
                productImage.setProduct(product);
                productImage.setCreatedAt(date);
                productImage.setCreatedBy("Luudd");
                productImage.setUpdatedAt(date);
                productImage.setUpdatedBy("Luudd");
                productImageRepository.save(productImage);
            }
            return ProductImageMapper.toProductImageDTO(productImage);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    @Transactional
    @Override
    public ProductImageDTO updateProductImage(ProductImageRequest productImageRequest, int id) {
        try {
            Date date = new Date();
            List<ProductImage> productImageList = productImageRepository.findAll();
            if (productImageRequest != null ) {
                for (ProductImage productImage: productImageList) {
                    if( productImage.getProduct().getProductId() == id ) {
                        productImage.setLink(productImageRequest.getLink());
                        productImage.setUpdatedAt(date);
                        productImage.setUpdatedBy("Luudd");
                        productImageRepository.save(productImage);
                        return ProductImageMapper.toProductImageDTO(productImage);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    @Override
    public List<ProductImageDTO> getAllImages() {
        try {
            List<ProductImage> productImageList = productImageRepository.findAll();
            List<ProductImageDTO> productImageDTOList = new ArrayList<>();
            if (productImageList != null) {
                for (ProductImage productImage: productImageList) {
                    productImageDTOList.add(ProductImageMapper.toProductImageDTO(productImage));
                }
                return productImageDTOList;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    @Override
    public List<ProductImageDTO> getImagesByProduct(int product_id) {
        List<ProductImageDTO> productImageDTOList = new ArrayList<>();
        try{
            List<ProductImage> productImageList = productImageRepository.getImagesByProductId(product_id);
            if ( productImageList != null ) {
                for (ProductImage productImage : productImageList) {
                    productImageDTOList.add(ProductImageMapper.toProductImageDTO(productImage));
                }
                return productImageDTOList;
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }

    @Override
    public String deleteImage(int id) {
        try {
            productImageRepository.deleteById(id);
            return "Success";
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "Unsucess";
    }
}
