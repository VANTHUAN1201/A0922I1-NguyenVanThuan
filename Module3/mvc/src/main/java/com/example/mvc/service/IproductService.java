package com.example.mvc.service;

import com.example.mvc.model.Product;

import java.util.List;

public interface IproductService {
    List<Product> findAll();
    Product findName(String name);
    void save(Product product);
    void edit(int id,Product product);
    void remove(int id);
}
