package com.epam.jwd.registrationinfitnessclub.service;

import com.epam.jwd.registrationinfitnessclub.entity.Client;

public class ClientValidator {
    private final Client client;

    public ClientValidator(Client client) {
        this.client = client;
    }

    public static final String NAME_REGEX = "[a-zA-Z-]+";
    public static final String PHONE_REGEX = "\\+[0-9]+";
    public static final String EMAIL_REGEX = "[0-9a-zA-Z-_.]+@[0-9a-zA-Z]+.[a-zA-Z]+";

    public boolean check() {
        return  checkName() && checkSurname() && checkPhone() && checkEmail();
    }

    public boolean checkName() {
        return client.getName().matches(NAME_REGEX);
    }

    public boolean checkSurname() {
        return client.getSurname().matches(NAME_REGEX);
    }

    public boolean checkPhone() {
        return client.getPhone().matches(PHONE_REGEX);
    }

    public boolean checkEmail() {
        return client.getEmail().matches(EMAIL_REGEX);
    }
}
