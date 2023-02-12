package com.my.fim.service.impl;

import com.my.fim.dto.NutriscoreDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Nutriscore;
import com.my.fim.repository.NutriscoreRepository;
import com.my.fim.service.NutriscoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NutriscoreServiceImpl implements NutriscoreService {

    private final NutriscoreRepository nutriscoreRepository;
    @Override
    public NutriscoreDto createNutriscore(NutriscoreDto nutriscoreDto) {
        Nutriscore nutriscore = new Nutriscore();
        nutriscore.setCode(nutriscoreDto.getCode());

        Nutriscore newNutriscore = nutriscoreRepository.save(nutriscore);

        NutriscoreDto nutriscoreResponse = new NutriscoreDto();
        nutriscoreResponse.setId(newNutriscore.getId());
        nutriscoreResponse.setCode(newNutriscore.getCode());
        return  nutriscoreResponse;
    }
    @Override
    public List<NutriscoreDto> getAllNutriscore() {
        List<Nutriscore> nutriscore = nutriscoreRepository.findAll();
        return nutriscore.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }
    @Override
    public NutriscoreDto getNutriscoreById(Long id) {
        Nutriscore nutriscore = nutriscoreRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Nutri-score non trouvé"));
        return mapToDto(nutriscore);
    }
    @Override
    public NutriscoreDto updateNutriscoreById(NutriscoreDto nutriscoreDto, Long id) {
        Nutriscore nutriscore = nutriscoreRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de mettre à jour le nutri-score"));

        nutriscore.setCode(nutriscoreDto.getCode());

        Nutriscore updateNutriscore = nutriscoreRepository.save(nutriscore);
        return mapToDto(updateNutriscore);
    }
    @Override
    public void deleteNutriscoreById(Long id) {
        Nutriscore nutriscore = nutriscoreRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de supprimer le nutri-score"));
        nutriscoreRepository.delete(nutriscore);
    }
    private NutriscoreDto mapToDto(Nutriscore nutriscore) {
        NutriscoreDto nutriscoreDto = new NutriscoreDto();
        nutriscoreDto.setCode(nutriscore.getCode());
        return nutriscoreDto;
    }
    private Nutriscore mapToEntity(NutriscoreDto nutriscoreDto) {
        Nutriscore nutriscore = new Nutriscore();
        nutriscore.setCode(nutriscoreDto.getCode());
        return nutriscore;
    }
}
