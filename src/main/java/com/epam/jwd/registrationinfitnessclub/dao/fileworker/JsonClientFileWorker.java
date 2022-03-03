package com.epam.jwd.registrationinfitnessclub.dao.fileworker;

import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JsonClientFileWorker implements FileWorker<Client> {
    public static final char NEW_LINE = '\n';
    private final File file;
    private final Class<Client> aClass;

    public JsonClientFileWorker(File file, Class<Client> aClass) {
        this.file = file;
        this.aClass = aClass;
    }

    @Override
    public Collection<Client> readCollection() throws FileWorkerException {
        ObjectMapper mapper = new ObjectMapper();
        Collection<Client> clients = new ArrayList<>();
        try {
            ObjectReader objectReader = mapper.reader();
            JsonParser jsonParser = objectReader.createParser(file);
            Iterator<Client> iterator = jsonParser.readValuesAs(Client.class);
            while(iterator.hasNext()) {
                clients.add(iterator.next());
            }
        } catch (IOException e) {
            throw new FileWorkerException("IOException in ObjectMapper.readValue", e);
        }
        return clients;
    }

    @Override
    public void writeCollection(Collection<Client> collection) throws FileWorkerException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            collection.stream().map(this::writeValueAsString).forEach(s -> stringBuilder.append(s).append(NEW_LINE));
        } catch (FileWorkerException e) {
            throw e;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new FileWorkerException("IOException in BufferedWriter.write()", e);
        }
    }

    private String writeValueAsString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new FileWorkerException("JsonProcessingException in ObjectMapper.writeValueAsString()", e);
        }
        return result;
    }
}
