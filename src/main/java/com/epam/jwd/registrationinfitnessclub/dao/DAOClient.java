package com.epam.jwd.registrationinfitnessclub.dao;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorkerException;
import com.epam.jwd.registrationinfitnessclub.entity.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


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
    public void load(FileWorker<Client> fileWorker) throws FileWorkerException {
        insert(fileWorker.readCollection());
    }

    @Override
    public void save(FileWorker<Client> fileWorker) throws FileWorkerException {
        fileWorker.writeCollection(clientMap.values());
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
    public Set<Long> getKeySet() {
        return clientMap.keySet();
    }

    @Override
    public Optional<Client> find(Long id) {
        return Optional.of(clientMap.get(id));
    }

    @Override
    public Collection<Client> findAll() {
        return clientMap.values();
    }
}
