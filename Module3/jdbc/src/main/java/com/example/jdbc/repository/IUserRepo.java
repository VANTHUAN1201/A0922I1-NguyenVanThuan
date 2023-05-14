package com.example.jdbc.repository;

import com.example.jdbc.model.User;

import java.util.List;

public interface IUserRepo {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void edit(User user );
    void remove(int id);
    List<User> findByCountry(String str);
    List<User> ascendingName();
    List<User> descendingName();
}
