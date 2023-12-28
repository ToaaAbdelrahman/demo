package com.trial.demo.domain;

import java.util.Objects;

public class SignInResponse {
    private String token;

    public SignInResponse() {
    }

    public SignInResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SignInResponse token(String token) {
        setToken(token);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SignInResponse)) {
            return false;
        }
        SignInResponse signInResponse = (SignInResponse) o;
        return Objects.equals(token, signInResponse.token);
    }

    @Override
    public String toString() {
        return "{" +
                " token='" + getToken() + "'" +
                "}";
    }

}
