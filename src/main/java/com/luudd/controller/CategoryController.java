package com.luudd.controller;

import com.luudd.model.dto.CategoryDTO;
import com.luudd.model.request.CategoryRequest;
import com.luudd.service.ICategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    // Create category
    @ApiOperation(value="Create category", response = CategoryDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/category")
    public ResponseEntity<?> createCategory (@RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequest));
    }

    // Update category
    @ApiOperation(value="Update category", response = CategoryDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("/api/category/{id}")
    public ResponseEntity<?> updateCategory (@RequestBody CategoryRequest categoryRequest, @PathVariable int id){
        return ResponseEntity.ok(categoryService.updateCategory(categoryRequest, id));
    }

    // Get all categories
    @ApiOperation(value="Get all categories", response = CategoryDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/category")
    public  ResponseEntity<?> getAllCategories (){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // Delete category
    @ApiOperation(value="Delete category", response = CategoryDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @DeleteMapping("/api/category/{id}")
    public ResponseEntity<?> deleteCategory (@PathVariable int id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
    // Get category by Id
    @ApiOperation(value="Get category by Id", response = CategoryDTO.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/api/category/{id}")
    public  ResponseEntity<?> getCategoryById (@PathVariable int id){
        return ResponseEntity.ok(categoryService.getCategorById(id));
    }
}
