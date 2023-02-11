package com.my.fim.service;

import com.my.fim.model.Brand;
import com.my.fim.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> findAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(Long id, Brand brand) {
        return brandRepository.findById(id)
                .map(element->{
                    element.setBrandName(brand.getBrandName());
                    return brandRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Marque non trouvée."));
    }

    @Override
    public String deleteBrand(Long id) {
        brandRepository.deleteById(id);
        return "Marque supprimée !";
    }
}
