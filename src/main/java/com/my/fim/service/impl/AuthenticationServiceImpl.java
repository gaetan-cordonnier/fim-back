package com.my.fim.service.impl;

import com.my.fim.dto.JwtDto;
import com.my.fim.dto.RefreshTokenDto;
import com.my.fim.dto.SignInDto;
import com.my.fim.dto.SignUpDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Role;
import com.my.fim.model.User;
import com.my.fim.repository.UserRepository;
import com.my.fim.service.AuthenticationService;
import com.my.fim.service.EmailService;
import com.my.fim.service.JwtService;
import com.my.fim.utils.ConstantUtils;
import com.my.fim.utils.GenerateCodeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final EmailService emailService;

    public String signUp(SignUpDto signUpDto) {
        User user = new User();
        Date date = new Date();

        user.setFirstname(signUpDto.getFirstname());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole(Role.USER);
        user.setValidated(false);
        user.setCreated(date);

        if (userRepository.findByEmail(signUpDto.getEmail()).isPresent()) {
            throw new NotFoundExceptionMessage(ConstantUtils.USER_ALREADY_EXIST);
        }

        User userSaved = userRepository.save(user);

        Context context = new Context();
        context.setVariable("firstname", userSaved.getFirstname());
        emailService.sendEmailWithHtmlTemplate(user.getEmail(), "Bienvenue sur FIM!", "create_account-template", context);

        return ConstantUtils.USER_CREATED;
    }

    public JwtDto signIn(SignInDto signInDto) {
        Date date = new Date();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getEmail(), signInDto.getPassword()));

        User user = userRepository.findByEmail(signInDto.getEmail()).orElseThrow(() -> new IllegalArgumentException(ConstantUtils.USER_BAD_CREDENTIALS));
        if (user.getValidated().equals(false)) {
            throw new RuntimeException(ConstantUtils.USER_NOT_VALIDATED);
        }

        user.setLogged(date);

        var jwt = jwtService.generateToken(user);
        var refreshJwt = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtDto jwtDto = new JwtDto();
        jwtDto.setToken(jwt);
        jwtDto.setRefreshToken(refreshJwt);

        userRepository.save(user);

        return jwtDto;
    }

    public JwtDto refreshToken(RefreshTokenDto refreshTokenDto) {
        String userEmail = jwtService.extractUserName(refreshTokenDto.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.USER_NOT_FOUND));
        if (jwtService.isValidToken(refreshTokenDto.getToken(), user)) {
            var jwt = jwtService.generateToken(user);
            var refreshJwt = jwtService.generateRefreshToken(new HashMap<>(), user);

            JwtDto jwtDto = new JwtDto();
            jwtDto.setToken(jwt);
            jwtDto.setRefreshToken(refreshJwt);

            return jwtDto;
        }
        return null;
    }

    public Boolean checkUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public String forgotPassword(String email) {
        Integer verificationCode = GenerateCodeUtils.randomCode();
        System.out.println(verificationCode);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.USER_NOT_FOUND));
        user.setVerification(verificationCode);
        userRepository.save(user);

        Context context = new Context();
        context.setVariable("email", email);
        context.setVariable("verificationCode", verificationCode);

        emailService.sendEmailWithHtmlTemplate(email, "Modification de mot de passe.", "forgot_password-template", context);

        return ConstantUtils.USER_PASSWORD_UPDATE_REQUEST;
    }

    public String updatePassword(SignInDto signInDto) {
        Date date = new Date();
        User user = userRepository.findByEmail(signInDto.getEmail()).orElseThrow(() -> new IllegalArgumentException("Cet identifiant n'existe pas."));
        user.setPassword(passwordEncoder.encode(signInDto.getPassword()));
        user.setUpdated(date);
        userRepository.save(user);

        return ConstantUtils.USER_PASSWORD_UPDATED;
    }
}
