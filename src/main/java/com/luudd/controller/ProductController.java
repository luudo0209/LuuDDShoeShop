package com.luudd.controller;

import com.luudd.model.dto.ProductDTO;
import com.luudd.model.request.ProductRequest;
import com.luudd.service.serviceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/products")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));

    }
}
