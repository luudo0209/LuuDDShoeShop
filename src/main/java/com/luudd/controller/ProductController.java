package com.luudd.controller;

import com.luudd.model.dto.ProductDTO;
import com.luudd.model.request.ProductRequest;
import com.luudd.service.serviceImpl.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create product
    @ApiOperation(value="Create a product", response = ProductDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/products")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        ProductDTO product = productService.createProduct(productRequest);
        return ResponseEntity.ok(product);
    }

    // Get all products
    @ApiOperation(value="Get all products", response = ProductDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/products")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Get product by Id
    @ApiOperation(value="Get product by Id", response = ProductDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // Get product by Name
    @ApiOperation(value="Get product by Name", response = ProductDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/productByName")
    public ResponseEntity<?> getProductByName(@RequestBody String name){
        return ResponseEntity.ok(productService.searchProductByName(name));
    }

    // Update product
    @ApiOperation(value="Update product", response = ProductDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PutMapping("/api/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody @Valid ProductRequest productRequest, @PathVariable int id) {
        return  ResponseEntity.ok(productService.updateProduct(productRequest, id));
    }

    // Delete product by id
    @ApiOperation(value="Delete product by id", response = ProductDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @DeleteMapping("/api/product/{id}")
    public  ResponseEntity<?> deleteProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
