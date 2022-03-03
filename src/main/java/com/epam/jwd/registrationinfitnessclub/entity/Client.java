package com.epam.jwd.registrationinfitnessclub.entity;

import java.io.Serializable;
import java.util.Objects;

public final class Client implements Serializable {
    private final String name;
    private final String surname;
    private final String phone;
    private final String email;

    public Client(){
        name = "";
        surname = "";
        phone = "";
        email = "";
    };

    public Client(String name, String surname, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
