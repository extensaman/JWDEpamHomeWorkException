package com.epam.jwd.registrationinfitnessclub.dao;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorkerException;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface DAOService<T> {
    void load(FileWorker<T> fileWorker) throws FileWorkerException;

    void save(FileWorker<T> fileWorker) throws FileWorkerException;

    void insert(Collection<T> collection);

    void insert(T object);

    void deleteAll();

    Set<Long> getKeySet();

    Optional<T> find(Long id);

    Collection<T> findAll();
}
