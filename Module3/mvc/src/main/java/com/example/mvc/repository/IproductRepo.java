package com.example.mvc.repository;

import com.example.mvc.model.Product;

import java.util.List;

public interface IproductRepo {
    List<Product> findAll();
    Product findById(int id);

    void save(Product product);
    void edit(Product product);
    void remove(int id);
}
