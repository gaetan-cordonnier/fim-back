package com.my.fim.service.impl;

import com.my.fim.dto.RecipeDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Recipe;
import com.my.fim.repository.RecipeRepository;
import com.my.fim.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setCookTime(recipeDto.getCookTime());
        recipe.setDifficulty(recipeDto.getDifficulty());
        recipe.setNbPerson(recipeDto.getNbPerson());
        recipe.setRating(recipeDto.getRating());

        Recipe newRecipe = recipeRepository.save(recipe);

        RecipeDto recipeResponse = new RecipeDto();
        recipeResponse.setId(newRecipe.getId());
        recipeResponse.setName(newRecipe.getName());
        recipeResponse.setPrepTime(newRecipe.getPrepTime());
        recipeResponse.setCookTime(newRecipe.getCookTime());
        recipeResponse.setDifficulty(newRecipe.getDifficulty());
        recipeResponse.setNbPerson(newRecipe.getNbPerson());
        recipeResponse.setRating(newRecipe.getRating());
        return  recipeResponse;
    }
    @Override
    public List<RecipeDto> getAllRecipe() {
        List<Recipe> recipe = recipeRepository.findAll();
        return recipe.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }
    @Override
    public RecipeDto getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Recette non trouvée"));
        return mapToDto(recipe);
    }
    @Override
    public RecipeDto updateRecipeById(RecipeDto recipeDto, Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de mettre à jour la recette"));

        recipe.setName(recipeDto.getName());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setCookTime(recipeDto.getCookTime());
        recipe.setDifficulty(recipeDto.getDifficulty());
        recipe.setNbPerson(recipeDto.getNbPerson());
        recipe.setRating(recipeDto.getRating());

        Recipe updateRecipe = recipeRepository.save(recipe);
        return mapToDto(updateRecipe);
    }
    @Override
    public void deleteRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de supprimer la recette"));
        recipeRepository.delete(recipe);
    }
    private RecipeDto mapToDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setPrepTime(recipe.getPrepTime());
        recipeDto.setCookTime(recipe.getCookTime());
        recipeDto.setDifficulty(recipe.getDifficulty());
        recipeDto.setNbPerson(recipe.getNbPerson());
        recipeDto.setRating(recipe.getRating());
        return recipeDto;
    }
    private Recipe mapToEntity(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setCookTime(recipeDto.getCookTime());
        recipe.setDifficulty(recipeDto.getDifficulty());
        recipe.setNbPerson(recipeDto.getNbPerson());
        recipe.setRating(recipeDto.getRating());
        return recipe;
    }
}
