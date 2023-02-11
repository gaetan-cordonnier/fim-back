package com.my.fim.service;

import com.my.fim.model.Food;

import java.util.List;

public interface FoodService {

    Food createFood(Food food);

    List<Food> findAllFood();

    Food updateFood(Long id, Food food);

    String deleteFood(Long id);

}
