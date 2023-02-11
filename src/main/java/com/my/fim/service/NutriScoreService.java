package com.my.fim.service;

import com.my.fim.model.NutriScore;

import java.util.List;

public interface NutriScoreService {

    NutriScore createNutriScore(NutriScore nutriScore);

    List<NutriScore> findAllNutriScore();

    NutriScore updateNutriScore(Long id, NutriScore nutriScore);

    String deleteNutriScore(Long id);

}
