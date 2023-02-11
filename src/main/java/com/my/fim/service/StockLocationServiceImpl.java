package com.my.fim.service;

import com.my.fim.model.StockLocation;
import com.my.fim.repository.StockLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockLocationServiceImpl implements StockLocationService {

    private final StockLocationRepository stockLocationRepository;

    @Override
    public StockLocation createStockLocation(StockLocation stockLocation) {return stockLocationRepository.save(stockLocation);}

    @Override
    public List<StockLocation> findAllStockLocation() {return stockLocationRepository.findAll();}

    @Override
    public StockLocation updateStockLocation(Long id, StockLocation stockLocation) {
        return stockLocationRepository.findById(id)
            .map(element->{
                element.setName(stockLocation.getName());
                return stockLocationRepository.save(element);
            }).orElseThrow(()->new RuntimeException("Emplacement de stockage non trouvé."));
    }

    @Override
    public String deleteStockLocation(Long id) {
        stockLocationRepository.deleteById(id);
        return "Emplacement de stockage supprimé !";
    }
}
