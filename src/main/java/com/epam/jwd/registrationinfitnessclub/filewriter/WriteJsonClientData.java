package com.epam.jwd.registrationinfitnessclub.filewriter;

import com.epam.jwd.registrationinfitnessclub.filereader.ReaderException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WriteJsonClientData implements Writer{
    @Override
    public void writeValue(File file, Object object) throws WriterException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, object);
        } catch (IOException e) {
            throw new WriterException("IOException in ObjectMapper.writeValue", e);
        }
    }
}
