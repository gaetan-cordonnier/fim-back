package com.my.fim.controller;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.StepDto;
import com.my.fim.service.StepService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/step")
@AllArgsConstructor
public class StepController {

    private final StepService stepService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StepDto> createStep(@RequestBody StepDto stepDto) {
        return new ResponseEntity<>(stepService.createStep(stepDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<StepDto>> getAllStep() {
        return new ResponseEntity<>(stepService.getAllStep(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<StepDto> getStepById(@PathVariable Long id) {
        return ResponseEntity.ok(stepService.getStepById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<StepDto> updateStepById(@RequestBody StepDto stepDto, @PathVariable("id") Long stepId) {
        StepDto response = stepService.updateStepById(stepDto, stepId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteStepById(@PathVariable("id") Long stepId) {
        stepService.deleteStepById(stepId);
        return new ResponseEntity<>(ConstantUtils.STEP_DELETED, HttpStatus.OK);
    }
}