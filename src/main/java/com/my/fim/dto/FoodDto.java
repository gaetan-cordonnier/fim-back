package com.my.fim.dto;

import com.my.fim.model.Allergen;
import com.my.fim.model.Brand;
import com.my.fim.model.Category;
import com.my.fim.model.Location;
import lombok.Data;

import java.util.List;

@Data
public class FoodDto {

    protected Long id;
    private String code;
    private String name;
    private Boolean biologic;
    private Float quantity;
    private Float consumed;
    private Float remaining;
    private String nutriScore;
    private Category category;
    private Brand brand;
    private Location location;
    private List<Allergen> allergens;
}
