package com.example.form_register.repository;

import com.example.form_register.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
