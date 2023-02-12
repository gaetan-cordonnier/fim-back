package com.my.fim.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RecipeDto {

    private Long id;
    private String name;
    private String prepTime;
    private String cookTime;
    private String difficulty;
    private Integer nbPerson;
    private Float rating;
}
