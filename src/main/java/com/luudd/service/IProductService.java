package com.luudd.service;

import com.luudd.entity.Product;
import com.luudd.model.dto.ProductDTO;
import com.luudd.model.request.ProductRequest;

import java.util.List;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
public interface IProductService {

    public ProductDTO createProduct(ProductRequest productRequest);

    public ProductDTO updateProduct(ProductRequest productRequest, int id);

    public String  deleteProduct(int id);

    public ProductDTO getProductById(int id);

    public ProductDTO searchProductByName(String name);

    public List<ProductDTO> getAllProducts();

}
