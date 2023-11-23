package com.my.fim.controller;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.FoodDto;
import com.my.fim.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/food")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FoodDto> createFood(@RequestBody FoodDto foodDto) {
        return new ResponseEntity<>(foodService.createFood(foodDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<FoodDto>> getAllFood() {
        return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<FoodDto> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<FoodDto> updateFoodById(@RequestBody FoodDto foodDto, @PathVariable("id") Long foodId) {
        FoodDto response = foodService.updateFoodById(foodDto, foodId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteFoodById(@PathVariable("id") Long foodId) {
        foodService.deleteFoodById(foodId);
        return new ResponseEntity<>(ConstantUtils.FOOD_DELETED, HttpStatus.OK);
    }
}
