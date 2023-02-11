package com.my.fim.controller;

import com.my.fim.service.RecipeService;
import com.my.fim.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/recipe")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping(path = "/create")
    public Recipe create(Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping(path = "/findAll")
        public List<Recipe> findAll() {
            return recipeService.findAllRecipe();
    }

    @PutMapping(path = "/update/{id}")
    public Recipe update(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return recipeService.deleteRecipe(id);
    }
}
