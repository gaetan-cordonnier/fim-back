package com.my.fim.service;

import com.my.fim.dto.AllergenDto;

import java.util.List;

public interface AllergenService {

    AllergenDto createAllergen(AllergenDto allergenDto);

    List<AllergenDto> getAllAllergen();

    AllergenDto getAllergenById(Long id);

    AllergenDto updateAllergenById(AllergenDto allergenDto, Long id);

    void deleteAllergenById(Long id);
}
