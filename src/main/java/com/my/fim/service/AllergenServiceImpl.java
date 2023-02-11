package com.my.fim.service;

import com.my.fim.model.Allergen;
import com.my.fim.repository.AllergenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AllergenServiceImpl implements AllergenService{

    private final AllergenRepository allergenRepository;

    @Override
    public Allergen createAllergen(Allergen allergen) {
        return allergenRepository.save(allergen);
    }

    @Override
    public List<Allergen> findAllAllergen() {
        return allergenRepository.findAll();
    }

    @Override
    public Allergen updateAllergen(Long id, Allergen allergen) {
        return allergenRepository.findById(id)
                .map(element->{
                    element.setName(allergen.getName());
                    return allergenRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Allergène non trouvé."));
    }

    @Override
    public String deleteAllergen(Long id) {
        allergenRepository.deleteById(id);
        return "Allergène supprimé !";
    }
}
