package com.my.fim.service.impl;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.FoodDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Food;
import com.my.fim.repository.FoodRepository;
import com.my.fim.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public FoodDto createFood(FoodDto foodDto) {
        Food food = new Food();
        food.setCode(foodDto.getCode());
        food.setName(foodDto.getName());
        food.setBiologic(foodDto.getBiologic());
        food.setQuantity(foodDto.getQuantity());
        food.setConsumed(foodDto.getConsumed());
        food.setRemaining(foodDto.getRemaining());
        food.setNutriScore(foodDto.getNutriScore());
        food.setCategory(foodDto.getCategory());
        food.setBrand(foodDto.getBrand());
        food.setLocation(foodDto.getLocation());
        food.setAllergens(foodDto.getAllergens());

        Food newFood = foodRepository.save(food);

        FoodDto foodResponse = new FoodDto();
        foodResponse.setId(newFood.getId());
        foodResponse.setCode(newFood.getCode());
        foodResponse.setName(newFood.getName());
        foodResponse.setBiologic(newFood.getBiologic());
        foodResponse.setQuantity(newFood.getQuantity());
        foodResponse.setConsumed(newFood.getConsumed());
        foodResponse.setRemaining(newFood.getRemaining());
        foodResponse.setNutriScore(newFood.getNutriScore());
        foodResponse.setCategory(newFood.getCategory());
        foodResponse.setBrand(newFood.getBrand());
        foodResponse.setLocation((newFood.getLocation()));
        foodResponse.setAllergens(newFood.getAllergens());
        return foodResponse;
    }

    @Override
    public List<FoodDto> getAllFood() {
        List<Food> food = foodRepository.findAll();
        return food.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }

    @Override
    public FoodDto getFoodById(Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.FOOD_NOT_FOUND));
        return mapToDto(food);
    }

    @Override
    public FoodDto updateFoodById(FoodDto foodDto, Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.FOOD_NOT_UPDATED));

        food.setCode(foodDto.getCode());
        food.setName(foodDto.getName());
        food.setBiologic(foodDto.getBiologic());
        food.setQuantity(foodDto.getQuantity());
        food.setConsumed(foodDto.getConsumed());
        food.setRemaining(foodDto.getRemaining());
        food.setNutriScore(foodDto.getNutriScore());
        food.setCategory(foodDto.getCategory());
        food.setBrand(foodDto.getBrand());
        food.setLocation(foodDto.getLocation());
        food.setAllergens(foodDto.getAllergens());

        Food updateFood = foodRepository.save(food);
        return mapToDto(updateFood);
    }

    @Override
    public void deleteFoodById(Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.FOOD_NOT_DELETED));
        foodRepository.delete(food);
    }

    private FoodDto mapToDto(Food food) {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setCode(food.getCode());
        foodDto.setName(food.getName());
        foodDto.setBiologic(food.getBiologic());
        foodDto.setQuantity(food.getQuantity());
        foodDto.setConsumed(food.getConsumed());
        foodDto.setRemaining(food.getRemaining());
        foodDto.setNutriScore(food.getNutriScore());
        foodDto.setCategory(food.getCategory());
        foodDto.setBrand(food.getBrand());
        foodDto.setLocation(food.getLocation());
        foodDto.setAllergens(food.getAllergens());
        return foodDto;
    }

    private Food mapToEntity(FoodDto foodDto) {
        Food food = new Food();
        food.setId(foodDto.getId());
        food.setCode(foodDto.getCode());
        food.setName(foodDto.getName());
        food.setBiologic(foodDto.getBiologic());
        food.setQuantity(foodDto.getQuantity());
        food.setConsumed(foodDto.getConsumed());
        food.setRemaining(foodDto.getRemaining());
        food.setNutriScore(foodDto.getNutriScore());
        food.setCategory(foodDto.getCategory());
        food.setBrand(foodDto.getBrand());
        food.setLocation(foodDto.getLocation());
        food.setAllergens(foodDto.getAllergens());
        return food;
    }
}
