package com.epam.jwd.registrationinfitnessclub.dao;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorkerException;
import com.epam.jwd.registrationinfitnessclub.entity.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


public class DAOAccount implements DAOService<Account> {
    private static final DAOAccount INSTANCE = new DAOAccount();
    private final Map<Long, Account> accountMap = new HashMap<>();
    private static Long nextId = 1L;

    private DAOAccount() {
    }

    public static DAOAccount getInstance() {
        return INSTANCE;
    }

    @Override
    public void load(FileWorker<Account> fileWorker) throws FileWorkerException {
        insert(fileWorker.readCollection());
    }

    @Override
    public void save(FileWorker<Account> fileWorker) throws FileWorkerException {
        fileWorker.writeCollection(accountMap.values());
    }

    @Override
    public void insert(Collection<Account> collection) {
        collection.forEach(client -> accountMap.put(nextId++, client));
    }

    @Override
    public void insert(Account object) {
        accountMap.put(nextId++, object);
    }

    @Override
    public void deleteAll() {
        accountMap.clear();
    }

    @Override
    public Set<Long> getKeySet() {
        return accountMap.keySet();
    }

    @Override
    public Optional<Account> find(Long id) {
        return Optional.of(accountMap.get(id));
    }

    @Override
    public Collection<Account> findAll() {
        return accountMap.values();
    }
}
