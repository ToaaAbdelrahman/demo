package com.trial.demo.domain;

public class SignInDto {
    private String email;
    private String password;

    public SignInDto() {
    }

    public SignInDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignInDto email(String email) {
        setEmail(email);
        return this;
    }

    public SignInDto password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

}
