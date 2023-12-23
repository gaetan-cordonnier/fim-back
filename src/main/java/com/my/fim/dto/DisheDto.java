package com.my.fim.dto;

import com.my.fim.model.Allergen;
import com.my.fim.model.Brand;
import com.my.fim.model.Location;
import lombok.Data;

import java.util.List;

@Data
public class DisheDto {

    protected Long id;
    private Long code;
    private String name;
    private String category;
    private Float quantity;
    private String nutriScore;
    private Brand brand;
    private Location location;
    private List<Allergen> allergens;
    
}
