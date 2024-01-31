package com.my.fim.dto;

import lombok.Data;

@Data
public class UserDto {

    protected Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private String language;
    private String theme;
    private Boolean validated;

}
