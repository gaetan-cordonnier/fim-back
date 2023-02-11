package com.my.fim.controller;

import com.my.fim.model.ReadyMeal;
import com.my.fim.service.ReadyMealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ready-meal")
@AllArgsConstructor
public class ReadyMealController {

    private final ReadyMealService readyMeal;

    @PostMapping(path = "/create")
    public ReadyMeal create(ReadyMeal recipe) {
        return readyMeal.createReadyMeal(recipe);
    }

    @GetMapping(path = "/findAll")
        public List<ReadyMeal> findAll() {
            return readyMeal.findAllReadyMeal();
    }

    @PutMapping(path = "/update/{id}")
    public ReadyMeal update(@PathVariable Long id, @RequestBody ReadyMeal recipe) {
        return readyMeal.updateReadyMeal(id, recipe);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return readyMeal.deleteReadyMeal(id);
    }
}
