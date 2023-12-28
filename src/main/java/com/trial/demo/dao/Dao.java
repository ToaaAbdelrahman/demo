package com.trial.demo.dao;

import java.security.NoSuchAlgorithmException;

import com.trial.demo.domain.SignInDto;
import com.trial.demo.domain.SignUpDto;

public interface Dao {
    public String signUpDao(SignUpDto signUp) throws NoSuchAlgorithmException;

    public String signInDao(SignInDto signIn) throws NoSuchAlgorithmException;

}
