package com.luudd.service;

import com.luudd.model.dto.CategoryDTO;
import com.luudd.model.request.CategoryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */

public interface ICategoryService {
    public CategoryDTO getCategorById(int id);

    public List<CategoryDTO> getAllCategories();

    public CategoryDTO createCategory(CategoryRequest categoryRequest);

    public CategoryDTO updateCategory(CategoryRequest categoryRequest, int id);

    public String deleteCategory(int id);


}
