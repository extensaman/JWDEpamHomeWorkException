package com.epam.jwd.registrationinfitnessclub.entity;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private final Client client;
    private String password;
    private AccountStatus status;

    public Account(Client client, String password, AccountStatus status) {
        this.client = client;
        this.password = password;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(client, account.client) &&
                Objects.equals(password, account.password) &&
                status == account.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, password, status);
    }

    @Override
    public String toString() {
        return "Account{" +
                "client=" + client +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
