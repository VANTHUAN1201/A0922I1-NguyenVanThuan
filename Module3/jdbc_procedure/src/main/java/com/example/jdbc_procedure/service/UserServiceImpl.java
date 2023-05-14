package com.example.jdbc_procedure.service;

import com.example.jdbc_procedure.model.User;
import com.example.jdbc_procedure.repository.IUserRepo;
import com.example.jdbc_procedure.repository.UserRepoImpl;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserRepo repo=new UserRepoImpl();
    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(int id) {
        return repo.findById(id);
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
    public void save(User user) {
        repo.save(user);
    }
}
