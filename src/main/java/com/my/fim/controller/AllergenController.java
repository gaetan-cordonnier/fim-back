package com.my.fim.controller;

import com.my.fim.model.Allergen;
import com.my.fim.service.AllergenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/allergen")
@AllArgsConstructor
public class AllergenController {
    private final AllergenService allergenService;

    @PostMapping(path = "/create")
    public Allergen create(Allergen food) {
        return allergenService.createAllergen(food);
    }

    @GetMapping(path = "/findAll")
    public List<Allergen> findAll() {
        return allergenService.findAllAllergen();
    }

    @PutMapping("/update/{id}")
    public Allergen update(@PathVariable Long id, @RequestBody Allergen food) {
        return allergenService.updateAllergen(id, food);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return allergenService.deleteAllergen(id);
    }

}
