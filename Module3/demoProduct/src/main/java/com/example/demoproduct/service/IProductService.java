package com.example.demoproduct.service;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();
    List<Category> findAllCategory();
    Product findIdProduct(int id);
    Category findIdCategory(int id_category);
    void  save(Product product);
    void  edit(Product product);
    void  remove(int id);
    List<Product> findName(String str);
}
