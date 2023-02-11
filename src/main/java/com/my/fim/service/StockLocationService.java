package com.my.fim.service;

import com.my.fim.model.StockLocation;

import java.util.List;

public interface StockLocationService {

    StockLocation createStockLocation(StockLocation stockLocation);

    List<StockLocation> findAllStockLocation() ;

    StockLocation updateStockLocation(Long id, StockLocation stockLocation);

    String deleteStockLocation(Long id);
}
