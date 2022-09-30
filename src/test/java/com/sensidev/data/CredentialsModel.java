package com.sensidev.data;

import com.github.javafaker.Faker;

public class CredentialsModel {

    private String email;
    private String password;

    public CredentialsModel() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        setEmail(email);
        String password = faker.internet().password();
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
