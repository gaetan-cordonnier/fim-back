package com.my.fim.service;

import com.my.fim.dto.DisheDto;

import java.util.List;

public interface DisheService {

    DisheDto createDishe(DisheDto disheDto);

    List<DisheDto> getAllDishe();

    DisheDto getDisheById(Long id);

    DisheDto updateDisheById(DisheDto disheDto, Long id);

    void deleteDisheById(Long id);
}
