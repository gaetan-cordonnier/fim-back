package com.my.fim.service.impl;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.AllergenDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Allergen;
import com.my.fim.repository.AllergenRepository;
import com.my.fim.service.AllergenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AllergenServiceImpl implements AllergenService {

    private final AllergenRepository allergenRepository;

    @Override
    public AllergenDto createAllergen(AllergenDto allergenDto) {
        Allergen allergen = new Allergen();
        allergen.setName(allergenDto.getName());

        Allergen newAllergen = allergenRepository.save(allergen);

        AllergenDto allergenResponse = new AllergenDto();
        allergenResponse.setId(newAllergen.getId());
        allergenResponse.setName(newAllergen.getName());
        return allergenResponse;
    }

    @Override
    public List<AllergenDto> getAllAllergen() {
        List<Allergen> allergen = allergenRepository.findAll();
        return allergen.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }

    @Override
    public AllergenDto getAllergenById(Long id) {
        Allergen allergen = allergenRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.ALLERGEN_NOT_FOUND));
        return mapToDto(allergen);
    }

    @Override
    public AllergenDto updateAllergenById(AllergenDto allergenDto, Long id) {
        Allergen allergen = allergenRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.ALLERGEN_NOT_UPDATED));

        allergen.setName(allergenDto.getName());

        Allergen updateAllergen = allergenRepository.save(allergen);
        return mapToDto(updateAllergen);
    }

    @Override
    public void deleteAllergenById(Long id) {
        Allergen allergen = allergenRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.ALLERGEN_NOT_DELETED));
        allergenRepository.delete(allergen);
    }

    private AllergenDto mapToDto(Allergen allergen) {
        AllergenDto allergenDto = new AllergenDto();
        allergenDto.setId(allergen.getId());
        allergenDto.setName(allergen.getName());
        return allergenDto;
    }

    private Allergen mapToEntity(AllergenDto allergenDto) {
        Allergen allergen = new Allergen();
        allergen.setId(allergenDto.getId());
        allergen.setName(allergenDto.getName());
        return allergen;
    }
}
