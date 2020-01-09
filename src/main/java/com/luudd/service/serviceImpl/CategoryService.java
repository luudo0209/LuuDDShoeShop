package com.luudd.service.serviceImpl;

import com.luudd.entity.Category;
import com.luudd.model.dto.CategoryDTO;
import com.luudd.model.mapper.CategoryMapper;
import com.luudd.model.request.CategoryRequest;
import com.luudd.repository.ICategoryRepository;
import com.luudd.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public CategoryDTO getCategorById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return CategoryMapper.toCategoryDTO(category.get());
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        if ( categoryList != null ) {
            for (Category category: categoryList) {
                categoryDTOList.add(CategoryMapper.toCategoryDTO(category));
            }
            return categoryDTOList;
        } else {
            return null;
        }
    }
    @Transactional
    @Override
    public CategoryDTO createCategory(CategoryRequest categoryRequest) {
        try {
            Date date = new Date();
            Category category = new Category();
            category.setCreatedAt(date);
            category.setCreatedBy("Luudd");
            category.setUpdatedAt(date);
            category.setUpdatedBy("Luudd");
            category.setCategoryName(categoryRequest.getCategoryName());
            categoryRepository.save(category);
            return CategoryMapper.toCategoryDTO(category);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Transactional
    @Override
    public CategoryDTO updateCategory(CategoryRequest categoryRequest, int id) {
        try {
            List<Category> categoryList = categoryRepository.findAll();
            Date date = new Date();
            if (categoryList != null) {
                for (Category category: categoryList) {
                    if (category.getCategoryId() == id) {
                        category.setCategoryName(categoryRequest.getCategoryName());
                        category.setUpdatedAt(date);
                        category.setUpdatedBy("Luudd");
                        categoryRepository.save(category);
                        return CategoryMapper.toCategoryDTO(category);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String deleteCategory(int id) {
        if (id >= 0){
            categoryRepository.deleteById(id);
            return "Success";
        }
        return "Unsuccess";

    }
}
