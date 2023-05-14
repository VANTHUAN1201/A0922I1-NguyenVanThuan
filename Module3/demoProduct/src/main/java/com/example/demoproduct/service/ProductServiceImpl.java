package com.example.demoproduct.service;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.model.Product;
import com.example.demoproduct.repository.IProductRepo;
import com.example.demoproduct.repository.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepo repo=new ProductRepoImpl();
    @Override
    public List<Product> findAllProduct() {
        return repo.findAllProduct();
    }

    @Override
    public List<Category> findAllCategory() {
        return repo.findAllCategory();
    }

    @Override
    public Product findIdProduct(int id) {
        return repo.findIdProduct(id);
    }

    @Override
    public Category findIdCategory(int id_category) {
        return repo.findIdCategory(id_category);
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public void edit(Product product) {
        repo.edit(product);
    }
    public void remove(int id) {
        repo.remove(id);
    }

    @Override
    public List<Product> findName(String str) {
        return repo.findName(str);
    }
}
