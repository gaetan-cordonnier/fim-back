package com.my.fim.dto;

import lombok.Data;

@Data
public class OriginDto {

    protected Long id;
    private String type;
    private String location;
    private String authorFirstname;
    private String authorLastname;
}
