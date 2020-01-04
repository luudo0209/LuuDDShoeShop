package com.luudd.service.serviceImpl;

import com.luudd.entity.Product;
import com.luudd.entity.ProductImage;
import com.luudd.model.dto.ProductDTO;
import com.luudd.model.mapper.ProductMapper;
import com.luudd.model.mapper.UserMapper;
import com.luudd.model.request.ProductRequest;
import com.luudd.repository.IProductRepository;
import com.luudd.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Transactional
    @Override
    public ProductDTO createProduct(ProductRequest productRequest) {
        //ProductDTO productDTO = new ProductDTO();
        Product product = new Product();
        ProductImage images = new ProductImage();
        Date date = new Date();
        //Create productDTO
       /* productDTO.setProductName(productRequest.getProductName());
        productDTO.setPrice(productRequest.getPrice());
        productDTO.setGenderFor(productRequest.getGenderFor());
        productDTO.setDescription(productRequest.getDescription());
        productDTO.setProductImage(productRequest.getProductImage());
        productDTO.setSize(productRequest.getSize());*/
        //productDTO.setCategory();
        //Create product
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setGenderFor(productRequest.getGenderFor());
        product.setDescription(productRequest.getDescription());
        product.setProductImage(productRequest.getProductImage());
        product.setSize(productRequest.getSize());
        product.setCreatedAt(date);
        product.setCreatedBy("Luudd");
        product.setUpdatedAt(date);
        product.setUpdatedBy("Luudd");
        productRepository.save(product);
        //Save images to imageTable
        images.setImages(productRequest.getProductImage());
        return ProductMapper.toProductDTo(product);
    }

    @Override
    public ProductDTO updateProduct(ProductRequest productRequest, int id) {
        List<Product> productList = productRepository.findAll();
        Date date = new Date();
        for (Product product : productList) {
            if(id == product.getProductId()) {
                product.setProductName(productRequest.getProductName());
                product.setPrice(productRequest.getPrice());
                product.setGenderFor(productRequest.getGenderFor());
                product.setDescription(productRequest.getDescription());
                product.setProductImage(productRequest.getProductImage());
                product.setSize(productRequest.getSize());
                product.setUpdatedAt(date);
                product.setUpdatedBy("Luudd");
                return ProductMapper.toProductDTo(product);
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public ProductDTO getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return ProductMapper.toProductDTo(product.get());
    }

    @Override
    public ProductDTO searchProductByName(String name) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product: productList) {
            productDTOList.add(ProductMapper.toProductDTo(product));
        }
        return productDTOList;
    }
}
