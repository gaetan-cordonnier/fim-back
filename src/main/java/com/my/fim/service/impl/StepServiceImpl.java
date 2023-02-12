package com.my.fim.service.impl;

import com.my.fim.dto.StepDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Step;
import com.my.fim.repository.StepRepository;
import com.my.fim.service.StepService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StepServiceImpl implements StepService {
    private final StepRepository stepRepository;
    @Override
    public StepDto createStep(StepDto stepDto) {
        Step step = new Step();
        step.setDescription(stepDto.getDescription());

        Step newStep = stepRepository.save(step);

        StepDto stepResponse = new StepDto();
        stepResponse.setId(newStep.getId());
        stepResponse.setDescription(newStep.getDescription());
        return  stepResponse;
    }
    @Override
    public List<StepDto> getAllStep() {
        List<Step> step = stepRepository.findAll();
        return step.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }
    @Override
    public StepDto getStepById(Long id) {
        Step step = stepRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Auteur non trouvé"));
        return mapToDto(step);
    }
    @Override
    public StepDto updateStepById(StepDto stepDto, Long id) {
        Step step = stepRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de mettre à jour l'auteur"));

        step.setDescription(stepDto.getDescription());

        Step updateStep = stepRepository.save(step);
        return mapToDto(updateStep);
    }
    @Override
    public void deleteStepById(Long id) {
        Step step = stepRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de supprimer l'auteur"));
        stepRepository.delete(step);
    }
    private StepDto mapToDto(Step step) {
        StepDto stepDto = new StepDto();
        stepDto.setDescription(step.getDescription());
        return stepDto;
    }
    private Step mapToEntity(StepDto stepDto) {
        Step step = new Step();
        step.setDescription(stepDto.getDescription());
        return step;
    }
}
