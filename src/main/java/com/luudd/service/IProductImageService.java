package com.luudd.service;

import com.luudd.model.dto.ProductImageDTO;
import com.luudd.model.request.ProductImageRequest;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
public interface IProductImageService {
    public ProductImageDTO createProductImage(ProductImageRequest productImageRequest);

    public ProductImageDTO updateProductImage(ProductImageRequest productImageRequest, int id);

    public ProductImageDTO getAllImages();

    public ProductImageDTO getImagesByProduct(int product_id);

    public String deleteImage(int id);
}
