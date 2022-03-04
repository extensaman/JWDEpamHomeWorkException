package com.epam.jwd.registrationinfitnessclub;

import com.epam.jwd.registrationinfitnessclub.dao.DAOAccount;
import com.epam.jwd.registrationinfitnessclub.dao.DAOClient;
import com.epam.jwd.registrationinfitnessclub.dao.DAOService;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorkerException;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.JsonFileWorker;
import com.epam.jwd.registrationinfitnessclub.entity.Account;
import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.epam.jwd.registrationinfitnessclub.logic.AccountException;
import com.epam.jwd.registrationinfitnessclub.logic.AccountWorker;
import com.epam.jwd.registrationinfitnessclub.utility.FileWithHardcodeClientCreator;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Write an application that provides the user with the ability
 * to register in a fitness club (the user enters data into a file or console,
 * we read it, validate it and save it to a map or a list)
 *
 * @author Aliaksandr Yusikau
 * @since 1.0
 */

public class Runner {
    public static final String CLIENT_FILE_PATH = "src/main/resources/requestFromFrontend.json";
    public static final String ACCOUNT_FILE_PATH = "src/main/resources/toFrontend.json";
    public static final Logger LOGGER = Logger.getLogger("RegistrationInFitnessClub");

    public static void main(String[] args) {
        File clientFile = new File(CLIENT_FILE_PATH);
        FileWorker<Client> clientFileWorker = new JsonFileWorker<>(clientFile, Client.class);

        try {
            FileWithHardcodeClientCreator.start(clientFileWorker);
        } catch (FileWorkerException e) {
            LOGGER.error(e.getMessage(), e);
        }

        DAOService<Client> clientDAOService = DAOClient.getInstance();
        DAOService<Account> accountDAOService = DAOAccount.getInstance();

        try {
            clientDAOService.load(clientFileWorker);
        } catch (FileWorkerException e) {
            LOGGER.error(e.getMessage(), e);
        }

        AccountWorker accountWorker = new AccountWorker(clientDAOService, accountDAOService);

        try {
            accountWorker.registerAllClient();
        } catch (AccountException e) {
            LOGGER.error(e.getMessage(), e);
        }

        File accountFile = new File(ACCOUNT_FILE_PATH);
        FileWorker<Account> accountFileWorker = new JsonFileWorker<>(accountFile, Account.class);

        try {
            accountDAOService.save(accountFileWorker);
        } catch (FileWorkerException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
