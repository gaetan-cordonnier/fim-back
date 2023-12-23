package com.my.fim.service;

import com.my.fim.dto.StepDto;

import java.util.List;

public interface StepService {

    StepDto createStep(StepDto stepDto);

    List<StepDto> getAllStep();

    StepDto getStepById(Long id);

    StepDto updateStepById(StepDto stepDto, Long id);

    void deleteStepById(Long id);
}
