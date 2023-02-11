package com.my.fim.service;

import com.my.fim.model.Allergen;

import java.util.List;

public interface AllergenService {
    Allergen createAllergen(Allergen allergen);

    List<Allergen> findAllAllergen();

    Allergen updateAllergen(Long id, Allergen allergen);

    String deleteAllergen(Long id);
}
