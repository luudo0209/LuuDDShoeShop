package com.luudd.controller;

import com.luudd.model.dto.ProductDTO;
import com.luudd.model.request.ProductRequest;
import com.luudd.service.serviceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        ProductDTO product = productService.createProduct(productRequest);
        return ResponseEntity.ok(product);
    }
}
