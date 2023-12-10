package com.my.fim.service.impl;

import com.my.fim.dto.SignUpDto;
import com.my.fim.model.Role;
import com.my.fim.model.User;
import com.my.fim.repository.UserRepository;
import com.my.fim.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User signUp(SignUpDto signUpDto) {
        User user = new User();

        user.setFirstname(signUpDto.getFirstname());
        user.setLastname(signUpDto.getLastname());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }
}
