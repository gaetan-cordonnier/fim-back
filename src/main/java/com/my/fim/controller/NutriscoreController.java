package com.my.fim.controller;

import com.my.fim.dto.NutriscoreDto;
import com.my.fim.model.Nutriscore;
import com.my.fim.service.NutriscoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/nutri-score")
@AllArgsConstructor
public class NutriscoreController {
    private final NutriscoreService nutriscoreService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NutriscoreDto> createNutriscore(@RequestBody NutriscoreDto nutriscoreDto) {
        return new ResponseEntity<>(nutriscoreService.createNutriscore(nutriscoreDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<NutriscoreDto>> getAllNutriscore() {
        return new ResponseEntity<>(nutriscoreService.getAllNutriscore(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<NutriscoreDto> getNutriscoreById(@PathVariable Long id) {
        return ResponseEntity.ok(nutriscoreService.getNutriscoreById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<NutriscoreDto> updateNutriscoreById(@RequestBody NutriscoreDto nutriscoreDto, @PathVariable("id") Long nutriscoreId) {
        NutriscoreDto response = nutriscoreService.updateNutriscoreById(nutriscoreDto, nutriscoreId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteNutriscoreById(@PathVariable("id") Long nutriscoreId) {
        nutriscoreService.deleteNutriscoreById(nutriscoreId);
        return new ResponseEntity<>("Nutri-score supprimé", HttpStatus.OK);
    }
}
