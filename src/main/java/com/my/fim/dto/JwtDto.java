package com.my.fim.dto;

import lombok.Data;

@Data
public class JwtDto {

    private String token;
    private String refreshToken;
}
