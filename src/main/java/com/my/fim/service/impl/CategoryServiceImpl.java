package com.my.fim.service.impl;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.CategoryDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Category;
import com.my.fim.repository.CategoryRepository;
import com.my.fim.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        Category newCategory = categoryRepository.save(category);

        CategoryDto categoryResponse = new CategoryDto();
        categoryResponse.setId(newCategory.getId());
        categoryResponse.setName(newCategory.getName());
        return categoryResponse;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> category = categoryRepository.findAll();
        return category.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.CATEGORY_NOT_FOUND));
        return mapToDto(category);
    }

    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.CATEGORY_NOT_UPDATED));

        category.setName(categoryDto.getName());

        Category updateCategory = categoryRepository.save(category);
        return mapToDto(updateCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.BRAND_NOT_DELETED));
        categoryRepository.delete(category);
    }

    private CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    private Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());

        return category;
    }
}
