package com.my.fim.service;

import com.my.fim.dto.SignUpDto;
import com.my.fim.model.User;

public interface AuthenticationService {

    User signUp(SignUpDto signUpDto);
}