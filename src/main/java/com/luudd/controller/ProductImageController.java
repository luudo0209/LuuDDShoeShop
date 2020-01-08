package com.luudd.controller;

import com.luudd.model.dto.CategoryDTO;
import com.luudd.model.dto.ProductImageDTO;
import com.luudd.model.request.BillRequest;
import com.luudd.model.request.ProductImageRequest;
import com.luudd.service.serviceImpl.BillService;
import com.luudd.service.serviceImpl.ProductImageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@RestController
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    // Create product image
    @ApiOperation(value="Create product image", response = ProductImageDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/productImage")
    public ResponseEntity<?> createProductImage (@RequestBody ProductImageRequest productImageRequest){
        return ResponseEntity.ok(productImageService.createProductImage(productImageRequest));
    }

    // Update product image
    @ApiOperation(value="Update product image", response = ProductImageDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PutMapping("/api/productImage/{id}")
    public ResponseEntity<?> updateProductImage (@RequestBody ProductImageRequest productImageRequest, int id){
        return ResponseEntity.ok(productImageService.updateProductImage(productImageRequest, id));
    }

    // Get product image
    @ApiOperation(value="Get product image", response = ProductImageDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/productImage")
    public ResponseEntity<?> getAllProductImages (){
        return ResponseEntity.ok(productImageService.getAllImages());
    }

    // Delete product image
    @ApiOperation(value="Delete product image", response = ProductImageDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @DeleteMapping("/api/productImage/{id}")
    public ResponseEntity<?> deleteProductImage (@PathVariable int id){
        return ResponseEntity.ok(productImageService.deleteImage(id));
    }
}
