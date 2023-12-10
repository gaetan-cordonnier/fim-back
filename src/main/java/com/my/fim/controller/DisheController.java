package com.my.fim.controller;

import com.my.fim.dto.DisheDto;
import com.my.fim.service.DisheService;
import com.my.fim.utils.ConstantUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user/ready-meal")
@AllArgsConstructor
public class DisheController {

    private final DisheService disheService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DisheDto> createDishe(@RequestBody DisheDto disheDto) {
        return new ResponseEntity<>(disheService.createDishe(disheDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<DisheDto>> getAllDishe() {
        return new ResponseEntity<>(disheService.getAllDishe(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<DisheDto> getDisheById(@PathVariable Long id) {
        return ResponseEntity.ok(disheService.getDisheById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<DisheDto> updateDisheById(@RequestBody DisheDto disheDto, @PathVariable("id") Long disheId) {
        DisheDto response = disheService.updateDisheById(disheDto, disheId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteDisheById(@PathVariable("id") Long disheId) {
        disheService.deleteDisheById(disheId);
        return new ResponseEntity<>(ConstantUtils.DISHE_DELETED, HttpStatus.OK);
    }
}
