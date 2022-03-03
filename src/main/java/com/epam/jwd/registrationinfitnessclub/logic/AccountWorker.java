package com.epam.jwd.registrationinfitnessclub.logic;

import com.epam.jwd.registrationinfitnessclub.dao.DAOService;
import com.epam.jwd.registrationinfitnessclub.entity.Account;
import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.epam.jwd.registrationinfitnessclub.service.AccountCreator;

import java.util.Optional;

public class AccountWorker {
    private final DAOService<Client> clientDAOService;
    private final DAOService<Account> accountDAOService;

    public AccountWorker(DAOService<Client> clientDAOService, DAOService<Account> accountDAOService) {
        this.clientDAOService = clientDAOService;
        this.accountDAOService = accountDAOService;
    }

    public void create(Long id, String password) {
        Optional<Client> optionalClient = clientDAOService.find(id);

        optionalClient.ifPresentOrElse(AccountCreator.getInstance().create(optionalClient.get(), password),
        throw new AccountException("No client with id = " + id));

    }
}
