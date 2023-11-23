package com.my.fim.service.impl;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.DisheDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Dishe;
import com.my.fim.repository.DisheRepository;
import com.my.fim.service.DisheService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DisheServiceImpl implements DisheService {

    private final DisheRepository disheRepository;

    @Override
    public DisheDto createDishe(DisheDto disheDto) {
        Dishe dishe = new Dishe();
        dishe.setCode(disheDto.getCode());
        dishe.setName(disheDto.getName());
        dishe.setCategory(disheDto.getCategory());
        dishe.setQuantity(disheDto.getQuantity());
        dishe.setNutriScore(disheDto.getNutriScore());
        dishe.setBrand(disheDto.getBrand());
        dishe.setLocation(disheDto.getLocation());
        dishe.setAllergens(disheDto.getAllergens());

        Dishe newDishe = disheRepository.save(dishe);

        DisheDto disheResponse = new DisheDto();
        disheResponse.setId(newDishe.getId());
        disheResponse.setCode(newDishe.getCode());
        disheResponse.setName(newDishe.getName());
        disheResponse.setCategory(newDishe.getCategory());
        disheResponse.setQuantity(newDishe.getQuantity());
        disheResponse.setNutriScore(newDishe.getNutriScore());
        disheResponse.setBrand(newDishe.getBrand());
        disheResponse.setLocation(newDishe.getLocation());
        disheResponse.setAllergens(newDishe.getAllergens());
        return disheResponse;
    }

    @Override
    public List<DisheDto> getAllDishe() {
        List<Dishe> dishe = disheRepository.findAll();
        return dishe.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }

    @Override
    public DisheDto getDisheById(Long id) {
        Dishe dishe = disheRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.DISHE_NOT_FOUND));
        return mapToDto(dishe);
    }

    @Override
    public DisheDto updateDisheById(DisheDto disheDto, Long id) {
        Dishe dishe = disheRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.DISHE_NOT_UPDATED));

        dishe.setCode(disheDto.getCode());
        dishe.setName(disheDto.getName());
        dishe.setCategory(disheDto.getCategory());
        dishe.setQuantity(disheDto.getQuantity());
        dishe.setNutriScore(disheDto.getNutriScore());
        dishe.setBrand(disheDto.getBrand());
        dishe.setLocation(disheDto.getLocation());
        dishe.setAllergens(disheDto.getAllergens());

        Dishe updateDishe = disheRepository.save(dishe);
        return mapToDto(updateDishe);
    }

    @Override
    public void deleteDisheById(Long id) {
        Dishe dishe = disheRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.DISHE_NOT_DELETED));
        disheRepository.delete(dishe);
    }

    private DisheDto mapToDto(Dishe dishe) {
        DisheDto disheDto = new DisheDto();
        disheDto.setId(dishe.getId());
        disheDto.setCode(dishe.getCode());
        disheDto.setName(dishe.getName());
        disheDto.setCategory(dishe.getCategory());
        disheDto.setQuantity(dishe.getQuantity());
        disheDto.setNutriScore(dishe.getNutriScore());
        disheDto.setBrand(dishe.getBrand());
        disheDto.setLocation(disheDto.getLocation());
        disheDto.setAllergens(disheDto.getAllergens());
        return disheDto;
    }

    private Dishe mapToEntity(DisheDto disheDto) {
        Dishe dishe = new Dishe();
        dishe.setId(disheDto.getId());
        dishe.setCode(disheDto.getCode());
        dishe.setName(disheDto.getName());
        dishe.setCategory(disheDto.getCategory());
        dishe.setQuantity(disheDto.getQuantity());
        dishe.setNutriScore(disheDto.getNutriScore());
        dishe.setBrand(disheDto.getBrand());
        dishe.setLocation(disheDto.getLocation());
        dishe.setAllergens(disheDto.getAllergens());
        return dishe;
    }
}
