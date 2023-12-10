package com.my.fim.controller;

import com.my.fim.dto.EthnicityDto;
import com.my.fim.service.EthnicityService;
import com.my.fim.utils.ConstantUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user/ethnicity")
@AllArgsConstructor
public class EthnicityController {

    private final EthnicityService ethnicityService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EthnicityDto> createEthnicity(@RequestBody EthnicityDto ethnicityDto) {
        return new ResponseEntity<>(ethnicityService.createEthnicity(ethnicityDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<EthnicityDto>> getAllEthnicity() {
        return new ResponseEntity<>(ethnicityService.getAllEthnicity(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<EthnicityDto> getEthnicityById(@PathVariable Long id) {
        return ResponseEntity.ok(ethnicityService.getEthnicityById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<EthnicityDto> updateEthnicityById(@RequestBody EthnicityDto ethnicityDto, @PathVariable("id") Long ethnicityId) {
        EthnicityDto response = ethnicityService.updateEthnicityById(ethnicityDto, ethnicityId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteEthnicityById(@PathVariable("id") Long ethnicityId) {
        ethnicityService.deleteEthnicityById(ethnicityId);
        return new ResponseEntity<>(ConstantUtils.ETHNICITY_DELETED, HttpStatus.OK);
    }
}
