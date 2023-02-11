package com.my.fim.service;

import com.my.fim.model.FoodCategory;
import com.my.fim.repository.FoodCategoryRepository;
import com.my.fim.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService{
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public FoodCategory createFoodCategory(FoodCategory foodCategory) {
        return foodCategoryRepository.save(foodCategory);
    }

    @Override
    public List<FoodCategory> findAllFoodCategory() {
        return foodCategoryRepository.findAll();
    }

    @Override
    public FoodCategory updateFoodCategory(Long id, FoodCategory foodCategory) {
        return foodCategoryRepository.findById(id)
                .map(element->{
                    element.setCategoryName(foodCategory.getCategoryName());
                    return foodCategoryRepository.save(element);
                }).orElseThrow(()->new RuntimeException("Catégorie alimentaire non trouvée."));
    }

    @Override
    public String deleteFoodCategory(Long id) {
        foodCategoryRepository.deleteById(id);
        return "Catégorie alimentaire supprimée !";
    }
}
