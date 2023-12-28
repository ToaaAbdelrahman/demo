package com.trial.demo.service;

import java.security.NoSuchAlgorithmException;

import com.trial.demo.dao.Dao;
import com.trial.demo.domain.SignInDto;
import com.trial.demo.domain.SignInResponse;
import com.trial.demo.domain.SignUpDto;
import com.trial.demo.exception.CustomExceptionHandler;
import com.trial.demo.exception.DemoError;

import org.flywaydb.core.api.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWork {
    @Autowired
    private Dao dao;

    public ServiceWork(Dao dao) {
        this.dao = dao;
    }

    public void signup(SignUpDto signup) throws NoSuchAlgorithmException {
        String result = dao.signUpDao(signup);
        if (!result.equalsIgnoreCase("SUCCESS")) {
            throw new CustomExceptionHandler.BadRequestException(result);
        }
    }

    public SignInResponse signIn(SignInDto signIn) throws NoSuchAlgorithmException {
        String result = dao.signInDao(signIn);
        if (isError(result))
            throw new CustomExceptionHandler.BadRequestException(result);
        return new SignInResponse(result);

    };

    public static boolean isError(String inputCode) {
        for (DemoError errorCode : DemoError.values()) {
            if (errorCode.getCode().equals(inputCode)) {
                return true;
            }
        }
        return false;
    }
}
