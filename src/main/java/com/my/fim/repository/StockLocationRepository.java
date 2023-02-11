package com.my.fim.repository;

import com.my.fim.model.StockLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockLocationRepository extends JpaRepository<StockLocation, Long> {
}
