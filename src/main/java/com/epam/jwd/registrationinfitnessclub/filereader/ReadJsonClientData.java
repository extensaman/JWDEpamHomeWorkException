package com.epam.jwd.registrationinfitnessclub.filereader;

import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJsonClientData implements Reader<Client>{

    @Override
    public Client readValue(File file, Class<Client> aClass) throws ReaderException{
        ObjectMapper mapper = new ObjectMapper();
        Client client = null;
        try {
            client = mapper.readValue(file, aClass);
        } catch (IOException e) {
            throw new ReaderException("IOException in ObjectMapper.readValue", e);
        }
        return client;
    }
}
