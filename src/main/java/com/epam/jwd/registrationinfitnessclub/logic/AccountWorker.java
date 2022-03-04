package com.epam.jwd.registrationinfitnessclub.logic;

import com.epam.jwd.registrationinfitnessclub.dao.DAOService;
import com.epam.jwd.registrationinfitnessclub.entity.Account;
import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.epam.jwd.registrationinfitnessclub.service.AccountCreator;
import com.epam.jwd.registrationinfitnessclub.utility.PasswordGenerator;

import java.util.Optional;

public class AccountWorker {
    public static final String NO_CLIENT_WITH_ID = "No client with id = ";
    public static final String NO_ACCOUNT_WITH_ID = "No account with id = ";
    private final DAOService<Client> clientDAOService;
    private final DAOService<Account> accountDAOService;

    public AccountWorker(DAOService<Client> clientDAOService, DAOService<Account> accountDAOService) {
        this.clientDAOService = clientDAOService;
        this.accountDAOService = accountDAOService;
    }

    public void registerAllClient() throws AccountException {
        for (Long clientId : clientDAOService.getKeySet()) {
            createAccount(clientId, PasswordGenerator.generate());
        }
    }

    public void createAccount(Long id, String password) throws AccountException {
        Optional<Client> optionalClient = clientDAOService.find(id);
        Account account;

        if (optionalClient.isPresent()) {
            account = AccountCreator.getInstance().create(optionalClient.get(), password);
        } else {
            throw new AccountException(NO_CLIENT_WITH_ID + id);
        }
        accountDAOService.insert(account);
    }

    public void changeAccountPassword(Long id, String newPassword) throws AccountException {
        Optional<Account> optionalAccount = accountDAOService.find(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setPassword(newPassword);
        } else {
            throw new AccountException(NO_ACCOUNT_WITH_ID + id);
        }
    }
}
