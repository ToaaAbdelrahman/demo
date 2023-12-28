package com.trial.demo.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trial.demo.domain.SignInDto;
import com.trial.demo.domain.SignInResponse;
import com.trial.demo.domain.SignUpDto;
import com.trial.demo.service.ServiceWork;

@RestController
public class DemoController {
    private ServiceWork service;

    public DemoController(ServiceWork service) {
        this.service = service;
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public void signup(@RequestBody SignUpDto signUpDto) throws NoSuchAlgorithmException {
        service.signup(signUpDto);
    }

    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public SignInResponse signIn(@RequestBody SignInDto SignInDto) throws NoSuchAlgorithmException {
        return service.signIn(SignInDto);
    }
}
