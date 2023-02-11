package com.my.fim.service;

import com.my.fim.model.ReadyMeal;

import java.util.List;

public interface ReadyMealService {

    ReadyMeal createReadyMeal(ReadyMeal readyMeal);

    List<ReadyMeal> findAllReadyMeal();

    ReadyMeal updateReadyMeal(Long id, ReadyMeal readyMeal);

    String deleteReadyMeal(Long id);

}
