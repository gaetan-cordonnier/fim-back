package com.my.fim.service;

import com.my.fim.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategory();

    CategoryDto getCategoryById(Long id);

    CategoryDto updateCategoryById(CategoryDto categoryDto, Long id);

    void deleteCategoryById(Long id);
}
