package com.epam.jwd.registrationinfitnessclub;

import com.epam.jwd.registrationinfitnessclub.dao.DAOClient;
import com.epam.jwd.registrationinfitnessclub.dao.DAOService;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.JsonClientFileWorker;
import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.epam.jwd.registrationinfitnessclub.logic.AccountWorker;
import com.epam.jwd.registrationinfitnessclub.service.FileWithClientCreator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Write an application that provides the user with the ability
 * to register in a fitness club (the user enters data into a file or console,
 * we read it, validate it and save it to a map or a list)
 *
 * @author Aliaksandr Yusikau
 * @since 1.0
 */

public class Runner {
    public static final String FILE_PATH = "src/main/resources/requestFromFrontend.json";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        FileWorker<Client> clientFileWorker = new JsonClientFileWorker(file, Client.class);
        FileWithClientCreator.start(clientFileWorker);

        DAOService<Client> clientDAOService = DAOClient.getInstance();
        clientDAOService.load(clientFileWorker);

        AccountWorker accountWorker = new AccountWorker(clientDAOService);
        accountWorker.create(1L, "dsfs");

        Collection<Client> result = new ArrayList<>();
        //result = clientFileWorker.readCollection();
        //System.out.println(result);
        /*WriteJsonClientData jsonWriter = new WriteJsonClientData();
        jsonWriter.writeValue(file, client01);*/
    }
}
