package com.example.form_register.service;

import com.example.form_register.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void create(User user);
}
