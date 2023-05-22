package com.example.jdbc_procedure.repository;

import com.example.jdbc_procedure.model.User;

import java.util.List;

public interface IUserRepo {
    List<User> findAll();
    User findById(int id);
    void edit(User user);
    void remove(int id);
    public void save(User user);
}