package com.market.service;

import com.market.dto.category.CategoryDTO;
import com.market.dto.category.CreateCategoryDTO;
import com.market.dto.category.UpdateCategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CreateCategoryDTO createCategoryDTO);
    CategoryDTO updateCategory(Long id,UpdateCategoryDTO updateCategoryDTO);
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getCategoryList();
    void deleteCategoryById(Long id);
}
