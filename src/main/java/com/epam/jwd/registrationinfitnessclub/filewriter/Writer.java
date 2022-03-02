package com.epam.jwd.registrationinfitnessclub.filewriter;

import java.io.File;

public interface Writer {
    void writeValue(File file, Object object) throws WriterException;
}
