package com.my.fim.service;

import com.my.fim.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe createRecipe(Recipe recipe);

    List<Recipe> findAllRecipe() ;

    Recipe updateRecipe(Long id, Recipe recipe);

    String deleteRecipe(Long id);
}
