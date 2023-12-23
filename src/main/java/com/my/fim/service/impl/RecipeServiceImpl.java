package com.my.fim.service.impl;

import com.my.fim.mapper.RecipeMapper;
import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.RecipeDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Recipe;
import com.my.fim.repository.RecipeRepository;
import com.my.fim.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = RecipeMapper.MAPPER.mapToModel(recipeDto);
        Recipe newRecipe = recipeRepository.save(recipe);
        RecipeDto recipeResponse = RecipeMapper.MAPPER.mapToDTO(newRecipe);
        return recipeResponse;
    }

    @Override
    public List<RecipeDto> getAllRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(RecipeMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.RECIPE_NOT_FOUND));
        return RecipeMapper.MAPPER.mapToDTO(recipe);
    }

    @Override
    public RecipeDto updateRecipeById(RecipeDto recipeDto, Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.RECIPE_NOT_UPDATED));

        Recipe newRecipe = RecipeMapper.MAPPER.mapToModel(recipeDto);
        recipe.setName(newRecipe.getName());
        recipe.setPrepTime(newRecipe.getPrepTime());
        recipe.setCookTime(newRecipe.getCookTime());
        recipe.setDifficulty(newRecipe.getDifficulty());
        recipe.setNbPerson(newRecipe.getNbPerson());
        recipe.setRating(newRecipe.getRating());
        recipe.setUpdateDate(newRecipe.getUpdateDate());
        recipe.setSteps(newRecipe.getSteps());
        recipe.setFoods(newRecipe.getFoods());
        recipe.setOrigin(newRecipe.getOrigin());
        recipe.setEthnicity(newRecipe.getEthnicity());

        Recipe updatedRecipe = recipeRepository.save(recipe);

        return RecipeMapper.MAPPER.mapToDTO(updatedRecipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.RECIPE_NOT_DELETED));
        recipeRepository.delete(recipe);
    }
}
