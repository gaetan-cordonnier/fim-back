package com.my.fim.service;

import com.my.fim.dto.FoodDto;

import java.util.List;

public interface FoodService {

    FoodDto createFood(FoodDto foodDto);

    List<FoodDto> getAllFood();

    FoodDto getFoodById(Long id);

    FoodDto updateFoodById(FoodDto foodDto, Long id);

    void deleteFoodById(Long id);
}
