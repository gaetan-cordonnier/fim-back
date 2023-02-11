package com.my.fim.controller;

import com.my.fim.service.StockLocationService;
import com.my.fim.model.StockLocation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
@AllArgsConstructor
public class StockLocationController {

    private final StockLocationService stockLocationService;

    @PostMapping(path = "/create")
    public StockLocation create(StockLocation stockLocation) {
        return stockLocationService.createStockLocation(stockLocation);
    }

    @GetMapping(path = "/findAll")
        public List<StockLocation> findAll() {
            return stockLocationService.findAllStockLocation();
    }

    @PutMapping(path = "/update/{id}")
    public StockLocation update(@PathVariable Long id, @RequestBody StockLocation stockLocation) {
        return stockLocationService.updateStockLocation(id, stockLocation);
    }

    @DeleteMapping(path = "/delete")
    public String delete(@PathVariable Long id) {
        return stockLocationService.deleteStockLocation(id);
    }
}
