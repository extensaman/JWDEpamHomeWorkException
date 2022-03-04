package com.epam.jwd.registrationinfitnessclub.utility;

import java.util.Random;

public class PasswordGenerator {
    public static final String SYMBOL_POOL = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.";
    public static final int PASSWORD_LENGTH = 10;

    private PasswordGenerator() {
    }

    public static String generate() {
        char[] password = new char[PASSWORD_LENGTH];
        Random random = new Random();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password[i] = SYMBOL_POOL.charAt(random.nextInt(SYMBOL_POOL.length()));
        }
        return new String(password);
    }
}
