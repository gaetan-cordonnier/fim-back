package com.my.fim.controller;

import com.my.fim.dto.SignUpDto;
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

    @PostMapping(path = "/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> signUp(@RequestBody SignUpDto signUpDto) {
        return new ResponseEntity<>(authenticationService.signUp(signUpDto), HttpStatus.CREATED);
    }
}