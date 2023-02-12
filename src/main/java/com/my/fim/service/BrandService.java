package com.my.fim.service;

import com.my.fim.dto.BrandDto;

import java.util.List;

public interface BrandService {

    BrandDto createBrand(BrandDto brandDto);

    List<BrandDto> getAllBrand();

    BrandDto getBrandById(Long id);

    BrandDto updateBrandById(BrandDto brandDto, Long id);

    void deleteBrandById(Long id);
}
