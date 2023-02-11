package com.my.fim.service;

import com.my.fim.model.Recipe;
import com.my.fim.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(Recipe recipe) {return recipeRepository.save(recipe);}

    @Override
    public List<Recipe> findAllRecipe() {return recipeRepository.findAll();}

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        return recipeRepository.findById(id)
            .map(element->{
                element.setName(recipe.getName());
                element.setPrepTime(recipe.getPrepTime());
                element.setCookTime(recipe.getCookTime());
                element.setDifficulty(recipe.getDifficulty());
                element.setNbPerson(recipe.getNbPerson());
                element.setRating(recipe.getRating());
                element.setAuthor((recipe.getAuthor()));
                return recipeRepository.save(element);
            }).orElseThrow(()->new RuntimeException("Recette non trouvée."));
    }

    @Override
    public String deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
        return "Recette supprimée !";
    }
}
