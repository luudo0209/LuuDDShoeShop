package com.luudd.model.mapper;

import com.luudd.entity.Product;
import com.luudd.entity.User;
import com.luudd.model.dto.ProductDTO;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
public class ProductMapper {
    public ProductDTO toProductDTo(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryId(product.getCategoryId());
        productDTO.setDescription(product.getDescription());
        productDTO.setGenderFor(product.getGenderFor());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductId(product.getProductImageId());
        return productDTO;
    }
}
