package com.my.fim.controller;

import com.my.fim.dto.*;
import com.my.fim.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(path = "/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto) {
        return new ResponseEntity<>(authenticationService.signUp(signUpDto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/signin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<JwtDto> signIn(@RequestBody SignInDto signInDto) {

        return new ResponseEntity<>(authenticationService.signIn(signInDto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/refresh")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<JwtDto> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {
        return new ResponseEntity<>(authenticationService.refreshToken(refreshTokenDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/check-email")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmailExistDto> checkUserExist(@RequestParam String email) {
        Boolean emailExist = authenticationService.checkUserExist(email);
        EmailExistDto response = new EmailExistDto(emailExist);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/forgot-password")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        return new ResponseEntity<>(authenticationService.forgotPassword(email), HttpStatus.OK);
    }

    @PutMapping(path = "/update-password")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updatePassword(@RequestBody SignInDto signInDto) {
        return new ResponseEntity<>(authenticationService.updatePassword(signInDto), HttpStatus.OK);
    }
}
