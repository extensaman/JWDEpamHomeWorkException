package com.epam.jwd.registrationinfitnessclub.filereader;

import java.io.File;
import java.io.IOException;

public interface Reader<T> {
    T readValue(File file, Class<T> aClass) throws ReaderException;
}
