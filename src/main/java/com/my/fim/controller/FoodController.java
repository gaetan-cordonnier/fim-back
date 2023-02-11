package com.my.fim.controller;

import com.my.fim.service.FoodService;
import com.my.fim.model.Food;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/food")
@AllArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping(path = "/create")
    public Food create(Food food) {
        return foodService.createFood(food);
    }

    @GetMapping(path = "/findAll")
    public List<Food> findAll() {
        return foodService.findAllFood();
    }

    @PutMapping("/update/{id}")
    public Food update(@PathVariable Long id, @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return foodService.deleteFood(id);
    }

}
