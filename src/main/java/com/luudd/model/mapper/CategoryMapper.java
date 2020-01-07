package com.luudd.model.mapper;

import com.luudd.entity.Category;
import com.luudd.model.dto.CategoryDTO;

/**
 * Created by Do Duc Luu on 1/5/2020.
 */
public class CategoryMapper {
        public  static CategoryDTO toCategoryDTO(Category category) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setCategoryName(category.getCategoryName());
            return categoryDTO;
        }
}
