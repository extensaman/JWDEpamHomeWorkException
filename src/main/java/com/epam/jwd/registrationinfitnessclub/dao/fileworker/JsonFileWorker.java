package com.epam.jwd.registrationinfitnessclub.dao.fileworker;

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

public class JsonFileWorker<T> implements FileWorker<T> {
    public static final char NEW_LINE = '\n';
    String IOEXCEPTION_IN_OBJECT_MAPPER_READ_VALUE = "IOException in ObjectMapper.readValue";
    String IOEXCEPTION_IN_BUFFERED_WRITER_WRITE = "IOException in BufferedWriter.write()";
    String JSON_PROCESSING_EXCEPTION_IN_OBJECT_MAPPER_WRITE_VALUE_AS_STRING =
            "JsonProcessingException in ObjectMapper.writeValueAsString()";
    private final File file;
    private final Class<T> aClass;

    public JsonFileWorker(File file, Class<T> aClass) {
        this.file = file;
        this.aClass = aClass;
    }

    @Override
    public Collection<T> readCollection() throws FileWorkerException {
        ObjectMapper mapper = new ObjectMapper();
        Collection<T> clients = new ArrayList<>();
        try {
            ObjectReader objectReader = mapper.reader();
            JsonParser jsonParser = objectReader.createParser(file);
            Iterator<T> iterator = jsonParser.readValuesAs(aClass);
            while (iterator.hasNext()) {
                clients.add(iterator.next());
            }
        } catch (IOException e) {
            throw new FileWorkerException(IOEXCEPTION_IN_OBJECT_MAPPER_READ_VALUE, e);
        }
        return clients;
    }

    @Override
    public void writeCollection(Collection<T> collection) throws FileWorkerException {
        StringBuilder stringBuilder = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        for (T object : collection) {
            try {
                stringBuilder.append(mapper.writeValueAsString(object)).append(NEW_LINE);
            } catch (JsonProcessingException e) {
                throw new FileWorkerException(JSON_PROCESSING_EXCEPTION_IN_OBJECT_MAPPER_WRITE_VALUE_AS_STRING, e);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(stringBuilder.toString());
            } catch (IOException e) {
                throw new FileWorkerException(IOEXCEPTION_IN_BUFFERED_WRITER_WRITE, e);
            }
        }
    }
}
