package com.luudd.model.mapper;

import com.luudd.entity.ProductImage;
import com.luudd.model.dto.ProductImageDTO;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
public class ProductImageMapper {
    public static ProductImageDTO toProductImageDTO(ProductImage productImage){
        ProductImageDTO productImageDTO = new ProductImageDTO();
        productImageDTO.setProductImageId(productImage.getProductImageId());
        productImageDTO.setLink(productImage.getLink());
        productImageDTO.setProductId(productImage.getProduct().getProductId());
        return productImageDTO;
    }
}
