package com.my.fim.controller;

import com.my.fim.dto.AllergenDto;
import com.my.fim.service.AllergenService;
import com.my.fim.utils.ConstantUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user/allergen")
@AllArgsConstructor
public class AllergenController {

    private final AllergenService allergenService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AllergenDto> createAllergen(@RequestBody AllergenDto allergenDto) {
        return new ResponseEntity<>(allergenService.createAllergen(allergenDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<AllergenDto>> getAllAllergen() {
        return new ResponseEntity<>(allergenService.getAllAllergen(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<AllergenDto> getAllergenById(@PathVariable Long id) {
        return ResponseEntity.ok(allergenService.getAllergenById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AllergenDto> updateAllergenById(@RequestBody AllergenDto allergenDto, @PathVariable("id") Long allergenId) {
        AllergenDto response = allergenService.updateAllergenById(allergenDto, allergenId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteAllergenById(@PathVariable("id") Long allergenId) {
        allergenService.deleteAllergenById(allergenId);
        return new ResponseEntity<>(ConstantUtils.ALLERGEN_DELETED, HttpStatus.OK);
    }
}
