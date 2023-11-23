package com.my.fim.controller;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.RecipeDto;
import com.my.fim.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/recipe")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        return new ResponseEntity<>(recipeService.createRecipe(recipeDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<RecipeDto>> getAllRecipe() {
        return new ResponseEntity<>(recipeService.getAllRecipe(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<RecipeDto> updateRecipeById(@RequestBody RecipeDto recipeDto, @PathVariable("id") Long recipeId) {
        RecipeDto response = recipeService.updateRecipeById(recipeDto, recipeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteRecipeById(@PathVariable("id") Long recipeId) {
        recipeService.deleteRecipeById(recipeId);
        return new ResponseEntity<>(ConstantUtils.RECIPE_DELETED, HttpStatus.OK);
    }
}
