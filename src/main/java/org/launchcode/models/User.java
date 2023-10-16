package org.launchcode.models;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private static int nextId = 1;
    private final int id;
    private String userName;
    private String email;
    private String password;
    private LocalDate dateRegistered;

    public User(String userName, String email, String password) {
        this.id = nextId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dateRegistered = LocalDate.now();
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
