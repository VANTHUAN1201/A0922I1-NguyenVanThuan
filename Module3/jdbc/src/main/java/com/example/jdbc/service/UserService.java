package com.example.jdbc.service;

import com.example.jdbc.model.User;
import com.example.jdbc.repository.IUserRepo;
import com.example.jdbc.repository.UserRepo;

import java.util.List;

public class UserService implements IUserService{
    IUserRepo repo=new UserRepo();
    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public void edit(User user) {
        repo.edit(user);
    }

    @Override
    public void remove(int id) {
        repo.remove(id);
    }

    @Override
    public List<User> findByCountry(String str) {
        return repo.findByCountry(str);
    }

    @Override
    public List<User> ascendingName() {
        return repo.ascendingName();
    }

    @Override
    public List<User> descendingName() {
        return repo.descendingName();
    }
}
