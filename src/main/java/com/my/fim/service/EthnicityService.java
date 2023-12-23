package com.my.fim.service;

import com.my.fim.dto.EthnicityDto;

import java.util.List;

public interface EthnicityService {

    EthnicityDto createEthnicity(EthnicityDto ethnicityDto);

    List<EthnicityDto> getAllEthnicity();

    EthnicityDto getEthnicityById(Long id);

    EthnicityDto updateEthnicityById(EthnicityDto ethnicityDto, Long id);

    void deleteEthnicityById(Long id);
}
