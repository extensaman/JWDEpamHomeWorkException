package com.epam.jwd.registrationinfitnessclub;

import com.epam.jwd.registrationinfitnessclub.entity.Client;
import com.epam.jwd.registrationinfitnessclub.filewriter.WriteJsonClientData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Write an application that provides the user with the ability
 * to register in a fitness club (the user enters data into a file or console,
 * we read it, validate it and save it to a map or a list)
 *
 * @author Aliaksandr Yusikau
 * @since 1.0
 */

public class Runner {
    public static final String FILE_PATH = "src/main/resources/requestFromFrontend.json";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        Client client01 = new Client("Bill", "Clinton","+19017658912","billy@whitehouse.us");
        WriteJsonClientData jsonWriter = new WriteJsonClientData();
        jsonWriter.writeValue(file, client01);
    }
}
