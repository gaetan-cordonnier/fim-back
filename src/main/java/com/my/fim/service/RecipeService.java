package com.my.fim.service;

import com.my.fim.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    RecipeDto createRecipe(RecipeDto recipeDto);

    List<RecipeDto> getAllRecipe();

    RecipeDto getRecipeById(Long id);

    RecipeDto updateRecipeById(RecipeDto recipeDto, Long id);

    void deleteRecipeById(Long id);
}
