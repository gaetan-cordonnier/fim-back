package com.my.fim.service;

import com.my.fim.model.OriginRecipe;

import java.util.List;

public interface OriginRecipeService {

    OriginRecipe createOriginRecipe(OriginRecipe originRecipe);

    List<OriginRecipe> findAllOriginRecipe();

    OriginRecipe updateOriginRecipe(Long id, OriginRecipe originRecipe);

    String deleteOriginRecipe(Long id);

}
