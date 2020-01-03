package com.luudd.service.serviceImpl;

import com.luudd.model.dto.ProductDTO;
import com.luudd.model.request.ProductRequest;
import com.luudd.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Service
public class ProductService implements IProductService {

    @Override
    public ProductDTO createProduct(ProductRequest productRequest) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(productRequest.getProductName());
        productDTO.setPrice(productRequest.getPrice());
        productDTO.setGenderFor(productRequest.getGenderFor());
        productDTO.setDescription(productRequest.getDescription());
        productDTO.setProductImageId(productRequest.getProductImageId());
        productDTO.setSize(productRequest.getSize());
        productDTO.setCategoryId(productRequest.getCategoryId());
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductRequest productRequest, int id) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public ProductDTO getProductById(int id) {
        return null;
    }

    @Override
    public ProductDTO searchProductByName(String name) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }
}
