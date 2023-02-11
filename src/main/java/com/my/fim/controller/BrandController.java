package com.my.fim.controller;

import com.my.fim.model.Brand;
import com.my.fim.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping(path = "/create")
    public Brand create(Brand food) {
        return brandService.createBrand(food);
    }

    @GetMapping(path = "/findAll")
    public List<Brand> findAll() {
        return brandService.findAllBrand();
    }

    @PutMapping("/update/{id}")
    public Brand update(@PathVariable Long id, @RequestBody Brand food) {
        return brandService.updateBrand(id, food);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return brandService.deleteBrand(id);
    }

}
