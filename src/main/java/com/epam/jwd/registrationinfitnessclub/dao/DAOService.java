package com.epam.jwd.registrationinfitnessclub.dao;

import com.epam.jwd.registrationinfitnessclub.dao.fileworker.FileWorker;

import java.util.Collection;

public interface DAOService <T>{
    void load (FileWorker<T> fileWorker);
    void insert (Collection<T> collection);
    void deleteAll();
    T find(Long id);
}
