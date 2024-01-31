package com.my.fim.service;

import com.my.fim.dto.JwtDto;
import com.my.fim.dto.RefreshTokenDto;
import com.my.fim.dto.SignInDto;
import com.my.fim.dto.SignUpDto;

public interface AuthenticationService {

    String signUp(SignUpDto signUpDto);

    JwtDto signIn(SignInDto signInDto);

    JwtDto refreshToken(RefreshTokenDto refreshTokenDto);

    Boolean checkUserExist(String email);

    String forgotPassword(String email);

    String updatePassword(SignInDto signInDto);
}
