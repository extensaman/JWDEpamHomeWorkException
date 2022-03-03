package com.epam.jwd.registrationinfitnessclub.dao;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.entity.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DAOClient implements DAOService<Client> {
    private static final DAOClient INSTANCE = new DAOClient();
    private final Map<Long, Client> clientMap = new HashMap<>();
    private static Long nextId = 1L;

    private DAOClient() {
    }

    public static DAOClient getInstance() {
        return INSTANCE;
    }

    @Override
    public void load(FileWorker<Client> fileWorker) {
        insert(fileWorker.readCollection());
    }

    @Override
    public void insert(Collection<Client> collection) {
        collection.forEach(client -> clientMap.put(nextId++, client));
    }

    @Override
    public void insert(Client client) {
        clientMap.put(nextId++, client);
    }

    @Override
    public void deleteAll() {
        clientMap.clear();
    }

    @Override
    public Optional<Client> find(Long id) {
        return Optional.of(clientMap.get(id));
    }
}
