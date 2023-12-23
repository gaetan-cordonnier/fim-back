package com.my.fim.dto;

import lombok.Data;

@Data
public class EmailExistDto {

    private boolean emailExists;

    public EmailExistDto(boolean emailExists) {
        this.emailExists = emailExists;
    }

}
