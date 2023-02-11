package com.my.fim.service;

import com.my.fim.model.FoodCategory;

import java.util.List;

public interface FoodCategoryService {
    FoodCategory createFoodCategory(FoodCategory foodCategory);

    List<FoodCategory> findAllFoodCategory();

    FoodCategory updateFoodCategory(Long id, FoodCategory foodCategory);

    String deleteFoodCategory(Long id);
}
