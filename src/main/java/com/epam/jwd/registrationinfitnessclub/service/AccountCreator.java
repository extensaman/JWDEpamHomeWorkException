package com.epam.jwd.registrationinfitnessclub.service;

import com.epam.jwd.registrationinfitnessclub.entity.Account;
import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.epam.jwd.registrationinfitnessclub.logic.AccountException;

import java.util.Optional;

public class AccountCreator {
    private static final AccountCreator INSTANCE = new AccountCreator();

    private AccountCreator() {
    }

    public static AccountCreator getInstance() {
        return INSTANCE;
    }

    public Optional<Account> create(Client client, String password) {
        ClientValidator clientValidator = new ClientValidator(client);

        if (!clientValidator.checkName()) {
            throw new AccountException("Client's name " + client.getName() + " is wrong");
        }
        if (!clientValidator.checkSurname()) {
            throw new AccountException("Client's surname " + client.getSurname() + " is wrong");
        }
        if (clientValidator.checkPhone()) {
            throw new AccountException("Client's phone " + client.getPhone() + " is wrong");
        }
        if (clientValidator.checkEmail()) {
            throw new AccountException("Client's email " + client.getEmail() + " is wrong");
        }

        return Optional.

    }
}
