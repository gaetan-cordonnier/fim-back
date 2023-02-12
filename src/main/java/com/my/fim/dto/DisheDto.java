package com.my.fim.dto;

import lombok.Data;

@Data
public class DisheDto {

    private Long id;
    private Long code;
    private String name;
    private String category;
    private Float quantity;
}
