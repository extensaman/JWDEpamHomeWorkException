package com.epam.jwd.registrationinfitnessclub.dao;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;
import com.epam.jwd.registrationinfitnessclub.entity.Client;

import java.util.Collection;
import java.util.Optional;

public interface DAOService <T>{
    void load (FileWorker<T> fileWorker);
    void insert (Collection<T> collection);
    void insert (T object);
    void deleteAll();
    Optional<T> find(Long id);
}
