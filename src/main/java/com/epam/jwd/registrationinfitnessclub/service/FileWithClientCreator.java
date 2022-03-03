package com.epam.jwd.registrationinfitnessclub.service;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorkerException;
import com.epam.jwd.registrationinfitnessclub.entity.Client;

import java.util.Collection;
import java.util.List;

public class FileWithClientCreator {

    private FileWithClientCreator() {
    }

    public static void start(FileWorker<Client> clientFileWorker) throws FileWorkerException {
        Client client01 = new Client("Bill", "Clinton", "+19017658912", "billy@whitehouse.us");
        Client client02 = new Client("James", "Cameron", "+43453671934", "james@hollywood.us");
        Client client03 = new Client("Andrey", "Gubin", "+79023331473", "gubin@popsa.ru");
        Client client04 = new Client("Christopher", "Columb", "+120322134413", "america@atlantic.city");
        Collection<Client> clients = List.of(client01, client02, client03, client04);
        clientFileWorker.writeCollection(clients);
    }
}
