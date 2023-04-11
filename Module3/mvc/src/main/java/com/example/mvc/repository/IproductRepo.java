package com.example.mvc.repository;

import com.example.mvc.model.Product;

import java.util.List;

public interface IproductRepo {
    List<Product> findAll();
    Product findName(String name);
    void save(Product product);
    void edit(int id,Product product);
    void remove(int id);
}
