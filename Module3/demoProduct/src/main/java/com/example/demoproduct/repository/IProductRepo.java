package com.example.demoproduct.repository;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAllProduct();
    List<Category> findAllCategory();
    Product findIdProduct(int id);
    Category findIdCategory(int id_category);
    void  save(Product product);
    void  edit(Product product);
    void  remove(int id);
    List<Product> findName(String str);
}
