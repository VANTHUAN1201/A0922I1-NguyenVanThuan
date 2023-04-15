package com.example.mvc.service;

import com.example.mvc.model.Product;
import com.example.mvc.repository.IproductRepo;
import com.example.mvc.repository.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements IproductService {
    IproductRepo repo=new ProductRepoImpl();

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public void edit( Product product) {
        repo.edit(product);
    }

    @Override
    public void remove(int id) {
        repo.remove(id);
    }


}
