package com.trial.demo.domain;

import java.util.Objects;

public class SignUpDto {
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public SignUpDto() {
    }

    public SignUpDto(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignUpDto email(String email) {
        setEmail(email);
        return this;
    }

    public SignUpDto firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public SignUpDto lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public SignUpDto password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SignUpDto)) {
            return false;
        }
        SignUpDto signUpDto = (SignUpDto) o;
        return Objects.equals(email, signUpDto.email) && Objects.equals(firstName, signUpDto.firstName)
                && Objects.equals(lastName, signUpDto.lastName) && Objects.equals(password, signUpDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, password);
    }

    @Override
    public String toString() {
        return "{" +
                " email='" + getEmail() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

}
