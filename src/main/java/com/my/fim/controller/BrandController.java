package com.my.fim.controller;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.BrandDto;
import com.my.fim.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/brand")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandDto) {
        return new ResponseEntity<>(brandService.createBrand(brandDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<BrandDto>> getAllBrand() {
        return new ResponseEntity<>(brandService.getAllBrand(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<BrandDto> getBrandById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.getBrandById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BrandDto> updateBrandById(@RequestBody BrandDto brandDto, @PathVariable("id") Long brandId) {
        BrandDto response = brandService.updateBrandById(brandDto, brandId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteBrandById(@PathVariable("id") Long brandId) {
        brandService.deleteBrandById(brandId);
        return new ResponseEntity<>(ConstantUtils.BRAND_DELETED, HttpStatus.OK);
    }
}
