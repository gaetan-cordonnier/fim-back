package com.my.fim.controller;

import com.my.fim.model.FoodCategory;
import com.my.fim.service.FoodCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/food-category")
@AllArgsConstructor
public class FoodCategoryController {
    private final FoodCategoryService foodCategoryService;

    @PostMapping(path = "/create")
    public FoodCategory create(FoodCategory food) {
        return foodCategoryService.createFoodCategory(food);
    }

    @GetMapping(path = "/findAll")
    public List<FoodCategory> findAll() {
        return foodCategoryService.findAllFoodCategory();
    }

    @PutMapping("/update/{id}")
    public FoodCategory update(@PathVariable Long id, @RequestBody FoodCategory food) {
        return foodCategoryService.updateFoodCategory(id, food);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return foodCategoryService.deleteFoodCategory(id);
    }

}
