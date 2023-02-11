package com.my.fim.service;

import com.my.fim.model.Ethnicity;

import java.util.List;

public interface EthnicityService {
    Ethnicity createEthnicity(Ethnicity ethnicity);

    List<Ethnicity> findAllEthnicity();

    Ethnicity updateEthnicity(Long id, Ethnicity ethnicity);

    String deleteEthnicity(Long id);
}
