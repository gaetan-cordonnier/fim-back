package com.my.fim.service;

import com.my.fim.model.Brand;

import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);

    List<Brand> findAllBrand();

    Brand updateBrand(Long id, Brand brand);

    String deleteBrand(Long id);
}
