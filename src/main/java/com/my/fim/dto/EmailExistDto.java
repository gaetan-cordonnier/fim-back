package com.my.fim.dto;

import lombok.Data;

@Data
public class EmailExistDto {

    private boolean emailExist;

    public EmailExistDto(boolean emailExists) {
        this.emailExist = emailExists;
    }

}
