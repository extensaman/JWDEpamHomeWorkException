package com.epam.jwd.registrationinfitnessclub.dao.fileworker;

import java.util.Collection;

public interface FileWorker<T> {

    Collection<T> readCollection() throws FileWorkerException;

    void writeCollection(Collection<T> collection) throws FileWorkerException;

}
