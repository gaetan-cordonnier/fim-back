package com.my.fim.service.impl;

import com.my.fim.dto.JwtDto;
import com.my.fim.dto.SignInDto;
import com.my.fim.dto.SignUpDto;
import com.my.fim.model.Role;
import com.my.fim.model.User;
import com.my.fim.repository.UserRepository;
import com.my.fim.service.AuthenticationService;
import com.my.fim.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public User signUp(SignUpDto signUpDto) {
        User user = new User();

        user.setFirstname(signUpDto.getFirstname());
        user.setLastname(signUpDto.getLastname());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public JwtDto signIn(SignInDto signInDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getEmail(), signInDto.getPassword()));

        var user = userRepository.findByEmail(signInDto.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        var refreshJwt = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtDto jwtDto = new JwtDto();
        jwtDto.setToken(jwt);
        jwtDto.setRefreshToken(refreshJwt);

        return jwtDto;
    }
}
