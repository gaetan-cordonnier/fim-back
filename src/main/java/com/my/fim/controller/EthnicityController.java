package com.my.fim.controller;

import com.my.fim.model.Ethnicity;
import com.my.fim.service.EthnicityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ethnicity")
@AllArgsConstructor
public class EthnicityController {
    private final EthnicityService ethnicityService;

    @PostMapping(path = "/create")
    public Ethnicity create(Ethnicity food) {
        return ethnicityService.createEthnicity(food);
    }

    @GetMapping(path = "/findAll")
    public List<Ethnicity> findAll() {
        return ethnicityService.findAllEthnicity();
    }

    @PutMapping("/update/{id}")
    public Ethnicity update(@PathVariable Long id, @RequestBody Ethnicity food) {
        return ethnicityService.updateEthnicity(id, food);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return ethnicityService.deleteEthnicity(id);
    }

}
