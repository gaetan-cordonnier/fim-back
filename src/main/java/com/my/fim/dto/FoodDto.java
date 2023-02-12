package com.my.fim.dto;

import lombok.Data;

@Data
public class FoodDto {

    private Long id;
    private Long code;
    private String name;
    private Boolean biologic;
    private Float quantity;
    private Float consumed;
    private Float remaining;
}
