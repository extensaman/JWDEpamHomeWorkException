package com.epam.jwd.registrationinfitnessclub.dao;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.entity.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DAOAccount implements DAOService<Account>{
    private static final DAOAccount INSTANCE = new DAOAccount();
    private final Map<Long, Account> accountMap = new HashMap<>();
    private static Long nextId = 1L;

    private DAOAccount() {
    }

    public static DAOAccount getInstance() {
        return INSTANCE;
    }

    @Override
    public void load(FileWorker<Account> fileWorker) {
        // will be implemented if necessary
    }

    @Override
    public void insert(Collection<Account> collection) {
        // will be implemented if necessary
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
    public Optional<Account> find(Long id) {
        // will be implemented if necessary
        return Optional.empty();
    }
}
