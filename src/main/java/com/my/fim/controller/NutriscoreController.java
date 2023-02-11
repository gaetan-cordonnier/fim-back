package com.my.fim.controller;

import com.my.fim.model.NutriScore;
import com.my.fim.service.NutriScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/nutri-score")
@AllArgsConstructor
public class NutriscoreController {
    private final NutriScoreService nutriScoreService;

    @PostMapping(path = "/create")
    public NutriScore create(NutriScore food) {
        return nutriScoreService.createNutriScore(food);
    }

    @GetMapping(path = "/findAll")
    public List<NutriScore> findAll() {
        return nutriScoreService.findAllNutriScore();
    }

    @PutMapping("/update/{id}")
    public NutriScore update(@PathVariable Long id, @RequestBody NutriScore food) {
        return nutriScoreService.updateNutriScore(id, food);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return nutriScoreService.deleteNutriScore(id);
    }

}
