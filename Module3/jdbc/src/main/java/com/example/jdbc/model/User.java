package com.example.jdbc.model;

public class User {
    int id;
    String name;
    String email;
    String country;

    public User() {
    }

    public User(int id, String name, String gmail, String country) {
        this.id = id;
        this.name = name;
        this.email = gmail;
        this.country = country;
    }
    public User( String name, String gmail, String country) {
        this.name = name;
        this.email = gmail;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}