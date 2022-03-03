package com.epam.jwd.registrationinfitnessclub.dao.fileworker;

public class FileWorkerException extends RuntimeException{
    public FileWorkerException() {
    }

    public FileWorkerException(String message) {
        super(message);
    }

    public FileWorkerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWorkerException(Throwable cause) {
        super(cause);
    }
}
