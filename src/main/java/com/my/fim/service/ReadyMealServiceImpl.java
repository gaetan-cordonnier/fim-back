package com.my.fim.service;

import com.my.fim.model.ReadyMeal;
import com.my.fim.repository.ReadyMealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReadyMealServiceImpl implements ReadyMealService{

    private final ReadyMealRepository readyMealRepository;
    @Override
    public ReadyMeal createReadyMeal(ReadyMeal readyMeal) {
        return readyMealRepository.save(readyMeal);
    }

    @Override
    public List<ReadyMeal> findAllReadyMeal() {
        return readyMealRepository.findAll();
    }

    @Override
    public ReadyMeal updateReadyMeal(Long id, ReadyMeal readyMeal) {
        return readyMealRepository.findById(id)
                .map(element->{
                    element.setCode(readyMeal.getCode());
                    element.setName(readyMeal.getName());
                    element.setCategory(readyMeal.getCategory());
                    element.setBrand(readyMeal.getBrand());
                    element.setQuantity(readyMeal.getQuantity());
                    return readyMealRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Plat préparé non trouvé."));
    }

    @Override
    public String deleteReadyMeal(Long id) {
        readyMealRepository.deleteById(id);
        return "Plat préparé supprimé !";
    }
}
