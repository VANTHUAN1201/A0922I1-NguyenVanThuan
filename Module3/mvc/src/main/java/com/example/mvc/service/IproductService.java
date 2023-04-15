package com.example.mvc.service;

import com.example.mvc.model.Product;

import java.util.List;

public interface IproductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void edit(Product product);
    void remove(int id);
}
