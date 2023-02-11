package com.my.fim.service;

import com.my.fim.model.Ethnicity;
import com.my.fim.repository.EthnicityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EthnicityServiceImpl implements EthnicityService{
    private final EthnicityRepository ethnicityRepository;

    @Override
    public Ethnicity createEthnicity(Ethnicity ethnicity) {
        return ethnicityRepository.save(ethnicity);
    }

    @Override
    public List<Ethnicity> findAllEthnicity() {
        return ethnicityRepository.findAll();
    }

    @Override
    public Ethnicity updateEthnicity(Long id, Ethnicity ethnicity) {
        return ethnicityRepository.findById(id)
                .map(element->{
                    element.setCountry(ethnicity.getCountry());
                    element.setContinent(ethnicity.getContinent());
                    return ethnicityRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Origine éthnique non trouvée."));
    }

    @Override
    public String deleteEthnicity(Long id) {
        ethnicityRepository.deleteById(id);
        return "Origine éthnique supprimée !";
    }
}
