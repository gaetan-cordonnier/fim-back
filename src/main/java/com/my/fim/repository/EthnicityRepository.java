package com.my.fim.repository;

import com.my.fim.model.Ethnicity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EthnicityRepository extends JpaRepository<Ethnicity, Long> {
}