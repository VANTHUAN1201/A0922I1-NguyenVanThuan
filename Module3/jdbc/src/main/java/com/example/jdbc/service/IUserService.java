package com.example.jdbc.service;

import com.example.jdbc.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void edit(User user );
    void remove(int id);
    List<User> findByCountry(String str);
    List<User> ascendingName();
    List<User> descendingName();
}
