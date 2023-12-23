package com.my.fim.service;

import com.my.fim.dto.JwtDto;
import com.my.fim.dto.RefreshTokenDto;
import com.my.fim.dto.SignInDto;
import com.my.fim.dto.SignUpDto;
import com.my.fim.model.User;

public interface AuthenticationService {

    boolean checkUserExist(String email);

    User signUp(SignUpDto signUpDto);

    JwtDto signIn(SignInDto signInDto);

    JwtDto refreshToken(RefreshTokenDto refreshTokenDto);
}
