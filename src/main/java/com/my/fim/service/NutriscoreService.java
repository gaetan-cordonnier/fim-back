package com.my.fim.service;

import com.my.fim.dto.NutriscoreDto;

import java.util.List;

public interface NutriscoreService {

    NutriscoreDto createNutriscore(NutriscoreDto nutriscoreDto);

    List<NutriscoreDto> getAllNutriscore();

    NutriscoreDto getNutriscoreById(Long id);

    NutriscoreDto updateNutriscoreById(NutriscoreDto nutriscoreDto, Long id);

    void deleteNutriscoreById(Long id);
}
