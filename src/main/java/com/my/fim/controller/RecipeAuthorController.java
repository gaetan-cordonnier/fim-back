package com.my.fim.controller;

import com.my.fim.model.RecipeAuthor;
import com.my.fim.service.RecipeAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/recipe-author")
@AllArgsConstructor
public class RecipeAuthorController {

    private final RecipeAuthorService recipeAuthorService;

    @PostMapping(path = "/create")
    public RecipeAuthor create(RecipeAuthor recipe) {
        return recipeAuthorService.createRecipeAuthor(recipe);
    }

    @GetMapping(path = "/findAll")
        public List<RecipeAuthor> findAll() {
            return recipeAuthorService.findAllRecipeAuthor();
    }

    @PutMapping(path = "/update/{id}")
    public RecipeAuthor update(@PathVariable Long id, @RequestBody RecipeAuthor recipe) {
        return recipeAuthorService.updateRecipeAuthor(id, recipe);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return recipeAuthorService.deleteRecipeAuthor(id);
    }
}
