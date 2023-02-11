package com.my.fim.service;

import com.my.fim.model.Food;
import com.my.fim.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;
@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodRepository foodRepository;
    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> findAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public Food updateFood(Long id, Food food) {
        return foodRepository.findById(id)
                .map(element->{
                    element.setCode(food.getCode());
                    element.setName(food.getName());
                    element.setBiologic(food.getBiologic());
                    element.setQuantity(food.getQuantity());
                    element.setConsumed(food.getConsumed());
                    element.setRemaining(food.getRemaining());
                    return foodRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Aliment non trouvé."));
    }

    @Override
    public String deleteFood(Long id) {
        foodRepository.deleteById(id);
        return "Aliment supprimé !";
    }
}
