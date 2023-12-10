package com.my.fim.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String generateToken(UserDetails userDetails);

    String extractUserName(String token);

    Boolean isValidToken(String token, UserDetails userDetails);
}
