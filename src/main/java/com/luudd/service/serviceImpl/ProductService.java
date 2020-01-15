package com.luudd.service.serviceImpl;

import com.luudd.entity.Category;
import com.luudd.entity.Product;
import com.luudd.entity.ProductImage;
import com.luudd.exception.ErrorResponse;
import com.luudd.exception.RecordNotFoundException;
import com.luudd.model.dto.ProductDTO;
import com.luudd.model.mapper.ProductMapper;
import com.luudd.model.mapper.UserMapper;
import com.luudd.model.request.ProductRequest;
import com.luudd.repository.ICategoryRepository;
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
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Transactional
    @Override
    public ProductDTO createProduct(ProductRequest productRequest) {
        Product product = new Product();
        ProductImage images = new ProductImage();
        Date date = new Date();
            Category category = iCategoryRepository.getCategoryById(productRequest.getCategoryId());
            if (category != null){
                product.setProductName(productRequest.getProductName());
                product.setPrice(productRequest.getPrice());
                product.setGenderFor(productRequest.getGenderFor());
                product.setDescription(productRequest.getDescription());
                product.setSize(productRequest.getSize());
                product.setCategory(category);
                product.setCreatedAt(date);
                product.setCreatedBy("Luudd");
                product.setUpdatedAt(date);
                product.setUpdatedBy("Luudd");
                product.setImage(productRequest.getImage());
                productRepository.save(product);
                return ProductMapper.toProductDTo(product);
            } else {
                throw new RecordNotFoundException("Cannot create!");
            }

//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
        //return null;
    }

    @Transactional
    @Override
    public ProductDTO updateProduct(ProductRequest productRequest, int id) {
        List<Product> productList = productRepository.findAll();
        Date date = new Date();
        try {
            Category category = iCategoryRepository.getCategoryById(productRequest.getCategoryId());
            for (Product product : productList) {
                if(id == product.getProductId() && category != null) {
                    product.setProductName(productRequest.getProductName());
                    product.setPrice(productRequest.getPrice());
                    product.setGenderFor(productRequest.getGenderFor());
                    product.setDescription(productRequest.getDescription());
                    product.setSize(productRequest.getSize());
                    product.setUpdatedAt(date);
                    product.setUpdatedBy("Luudd");
                    return ProductMapper.toProductDTo(product);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteProduct(int id) {
        if ( id >= 0 ) {
            productRepository.deleteById(id);
            return "Success";
        } else {
            return "Unsucess";
        }
    }

    @Override
    public ProductDTO getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return ProductMapper.toProductDTo(product.get());
    }

    @Override
    public ProductDTO searchProductByName(String name) {
        List<ProductDTO> productDTOList = getAllProducts();
        for (ProductDTO productDTO: productDTOList){
            if (name.equalsIgnoreCase(productDTO.getProductName())){
                return productDTO;
            }
        }
        return null;
    }
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        if ( productList != null ) {
            for (Product product : productList) {
                productDTOList.add(ProductMapper.toProductDTo(product));
            }
            return productDTOList;
        }
        return null;
    }
}
