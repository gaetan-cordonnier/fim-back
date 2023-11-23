package com.my.fim.dto;

import com.my.fim.model.Ethnicity;
import com.my.fim.model.Food;
import com.my.fim.model.Origin;
import com.my.fim.model.Step;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RecipeDto {

    protected Long id;
    private String name;
    private String prepTime;
    private String cookTime;
    private String difficulty;
    private Integer nbPerson;
    private Float rating;
    private Date creationDate;
    private Date updateDate;
    private List<Step> steps;
    private List<Food> foods;
    private Origin origin;
    private Ethnicity ethnicity;

}
