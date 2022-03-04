package com.epam.jwd.registrationinfitnessclub.service;

import com.epam.jwd.registrationinfitnessclub.entity.Account;
import com.epam.jwd.registrationinfitnessclub.entity.AccountStatus;
import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.epam.jwd.registrationinfitnessclub.logic.AccountException;

public class AccountCreator {
    private static final AccountCreator INSTANCE = new AccountCreator();
    public static final String CLIENT_S_NAME = "Client's name ";
    public static final String IS_WRONG = " is wrong";
    public static final String CLIENT_S_SURNAME = "Client's surname ";
    public static final String CLIENT_S_PHONE = "Client's phone ";
    public static final String CLIENT_S_EMAIL = "Client's email ";

    private AccountCreator() {
    }

    public static AccountCreator getInstance() {
        return INSTANCE;
    }

    public Account create(Client client, String password) throws AccountException {
        ClientValidator clientValidator = new ClientValidator(client);

        if (!clientValidator.checkName()) {
            throw new AccountException(CLIENT_S_NAME + client.getName() + IS_WRONG);
        }
        if (!clientValidator.checkSurname()) {
            throw new AccountException(CLIENT_S_SURNAME + client.getSurname() + IS_WRONG);
        }
        if (!clientValidator.checkPhone()) {
            throw new AccountException(CLIENT_S_PHONE + client.getPhone() + IS_WRONG);
        }
        if (!clientValidator.checkEmail()) {
            throw new AccountException(CLIENT_S_EMAIL + client.getEmail() + IS_WRONG);
        }

        return new Account(client, password, AccountStatus.REGISTERED);
    }
}
