package com.my.fim.service.impl;

import com.my.fim.dto.EthnicityDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Ethnicity;
import com.my.fim.repository.EthnicityRepository;
import com.my.fim.service.EthnicityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EthnicityServiceImpl implements EthnicityService {
    private final EthnicityRepository ethnicityRepository;
    @Override
    public EthnicityDto createEthnicity(EthnicityDto ethnicityDto) {
        Ethnicity ethnicity = new Ethnicity();
        ethnicity.setCountry(ethnicityDto.getCountry());
        ethnicity.setContinent(ethnicityDto.getContinent());

        Ethnicity newEthnicity = ethnicityRepository.save(ethnicity);

        EthnicityDto ethnicityResponse = new EthnicityDto();
        ethnicityResponse.setId(newEthnicity.getId());
        ethnicityResponse.setCountry(newEthnicity.getCountry());
        ethnicityResponse.setContinent(newEthnicity.getContinent());
        return  ethnicityResponse;
    }
    @Override
    public List<EthnicityDto> getAllEthnicity() {
        List<Ethnicity> ethnicity = ethnicityRepository.findAll();
        return ethnicity.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }
    @Override
    public EthnicityDto getEthnicityById(Long id) {
        Ethnicity ethnicity = ethnicityRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Origine éthnique non trouvée"));
        return mapToDto(ethnicity);
    }
    @Override
    public EthnicityDto updateEthnicityById(EthnicityDto ethnicityDto, Long id) {
        Ethnicity ethnicity = ethnicityRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de mettre à jour l'origine éthnique"));

        ethnicity.setCountry(ethnicityDto.getCountry());
        ethnicity.setContinent(ethnicityDto.getContinent());

        Ethnicity updateEthnicity = ethnicityRepository.save(ethnicity);
        return mapToDto(updateEthnicity);
    }
    @Override
    public void deleteEthnicityById(Long id) {
        Ethnicity ethnicity = ethnicityRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de supprimer l'origine éthnique"));
        ethnicityRepository.delete(ethnicity);
    }
    private EthnicityDto mapToDto(Ethnicity ethnicity) {
        EthnicityDto ethnicityDto = new EthnicityDto();
        ethnicityDto.setCountry(ethnicity.getCountry());
        ethnicityDto.setContinent(ethnicity.getContinent());
        return ethnicityDto;
    }
    private Ethnicity mapToEntity(EthnicityDto ethnicityDto) {
        Ethnicity ethnicity = new Ethnicity();
        ethnicity.setCountry(ethnicityDto.getCountry());
        ethnicity.setContinent(ethnicityDto.getContinent());
        return ethnicity;
    }
}
