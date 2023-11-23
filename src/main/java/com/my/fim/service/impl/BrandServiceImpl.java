package com.my.fim.service.impl;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.BrandDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Brand;
import com.my.fim.repository.BrandRepository;
import com.my.fim.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public BrandDto createBrand(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());

        Brand newBrand = brandRepository.save(brand);

        BrandDto brandResponse = new BrandDto();
        brandResponse.setId(newBrand.getId());
        brandResponse.setName(newBrand.getName());
        return brandResponse;
    }

    @Override
    public List<BrandDto> getAllBrand() {
        List<Brand> brand = brandRepository.findAll();
        return brand.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }

    @Override
    public BrandDto getBrandById(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.BRAND_NOT_FOUND));
        return mapToDto(brand);
    }

    @Override
    public BrandDto updateBrandById(BrandDto brandDto, Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.BRAND_NOT_UPDATED));

        brand.setName(brandDto.getName());

        Brand updateBrand = brandRepository.save(brand);
        return mapToDto(updateBrand);
    }

    @Override
    public void deleteBrandById(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.BRAND_NOT_DELETED));
        brandRepository.delete(brand);
    }

    private BrandDto mapToDto(Brand brand) {
        BrandDto brandDto = new BrandDto();
        brandDto.setId(brand.getId());
        brandDto.setName(brand.getName());
        return brandDto;
    }

    private Brand mapToEntity(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setId(brandDto.getId());
        brand.setName(brandDto.getName());
        return brand;
    }
}
