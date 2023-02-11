package com.my.fim.service;

import com.my.fim.model.RecipeAuthor;

import java.util.List;

public interface RecipeAuthorService {

    RecipeAuthor createRecipeAuthor(RecipeAuthor recipeAuthor);

    List<RecipeAuthor> findAllRecipeAuthor() ;

    RecipeAuthor updateRecipeAuthor(Long id, RecipeAuthor recipeAuthor);

    String deleteRecipeAuthor(Long id);
}
