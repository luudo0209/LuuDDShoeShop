package com.luudd.model.mapper;

import com.luudd.entity.Product;
import com.luudd.entity.ProductImage;
import com.luudd.entity.User;
import com.luudd.model.dto.ProductDTO;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
public class ProductMapper {
    public static ProductDTO toProductDTo(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setSize(product.getSize());
        productDTO.setDescription(product.getDescription());
        productDTO.setGenderFor(product.getGenderFor());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory_id(product.getCategory() != null ? product.getCategory().getCategoryId(): null);
        return productDTO;
    }
}
