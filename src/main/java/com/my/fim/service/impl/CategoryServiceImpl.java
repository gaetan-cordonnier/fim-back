package com.my.fim.service.impl;

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
        Category brand = new Category();
        brand.setName(categoryDto.getName());

        Category newCategory = categoryRepository.save(brand);

        CategoryDto brandResponse = new CategoryDto();
        brandResponse.setId(newCategory.getId());
        brandResponse.setName(newCategory.getName());
        return  brandResponse;
    }
    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> brand = categoryRepository.findAll();
        return brand.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }
    @Override
    public CategoryDto getCategoryById(Long id) {
        Category brand = categoryRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Catégorie non trouvée"));
        return mapToDto(brand);
    }
    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto, Long id) {
        Category brand = categoryRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de mettre à jour la catégorie"));

        brand.setName(categoryDto.getName());

        Category updateCategory = categoryRepository.save(brand);
        return mapToDto(updateCategory);
    }
    @Override
    public void deleteCategoryById(Long id) {
        Category brand = categoryRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de supprimer la catégorie"));
        categoryRepository.delete(brand);
    }
    private CategoryDto mapToDto(Category brand) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(brand.getName());
        return categoryDto;
    }
    private Category mapToEntity(CategoryDto categoryDto) {
        Category brand = new Category();
        brand.setName(categoryDto.getName());
        return brand;
    }
}
