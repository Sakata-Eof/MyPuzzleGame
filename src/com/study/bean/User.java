package com.study.bean;

import java.util.Objects;

public class User {
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{name = " + name + ", password = " + password + "}";
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if (o instanceof User) {
            return name.equals(((User) o).name)&& password.equals(((User) o).password);
        }
        return false;
    }
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
