package com.my.fim.controller;

import com.my.fim.dto.*;
import com.my.fim.model.User;
import com.my.fim.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @GetMapping(path = "/check-email")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmailExistDto> checkUserExist(@RequestParam String email) {
        boolean emailExists = authenticationService.checkUserExist(email);
        EmailExistDto response = new EmailExistDto(emailExists);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> signUp(@RequestBody SignUpDto signUpDto) {
        return new ResponseEntity<>(authenticationService.signUp(signUpDto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/signin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<JwtDto> signUp(@RequestBody SignInDto signInDto) {
        return new ResponseEntity<>(authenticationService.signIn(signInDto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/refresh")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<JwtDto> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {
        return new ResponseEntity<>(authenticationService.refreshToken(refreshTokenDto), HttpStatus.CREATED);
    }
}
