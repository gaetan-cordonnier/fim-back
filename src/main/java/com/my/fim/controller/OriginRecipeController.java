package com.my.fim.controller;

import com.my.fim.model.OriginRecipe;
import com.my.fim.service.OriginRecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/origin-recipe")
@AllArgsConstructor
public class OriginRecipeController {
    private final OriginRecipeService originRecipeService;

    @PostMapping(path = "/create")
    public OriginRecipe create(OriginRecipe food) {
        return originRecipeService.createOriginRecipe(food);
    }

    @GetMapping(path = "/findAll")
    public List<OriginRecipe> findAll() {
        return originRecipeService.findAllOriginRecipe();
    }

    @PutMapping("/update/{id}")
    public OriginRecipe update(@PathVariable Long id, @RequestBody OriginRecipe food) {
        return originRecipeService.updateOriginRecipe(id, food);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return originRecipeService.deleteOriginRecipe(id);
    }

}
