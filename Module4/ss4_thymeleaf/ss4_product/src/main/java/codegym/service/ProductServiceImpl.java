package codegym.service;

import codegym.model.Category;
import codegym.model.Product;
import codegym.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepositoryImpl repository;
    @Override
    public List<Product> findAllProduct() {
        return repository.findAllProduct();
    }

    @Override
    public List<Category> findAllCategory() {
        return repository.findAllCategory();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public Product findByIdProduct(int id) {
        return repository.findByIdProduct(id);
    }

    @Override
    public List<Product> findByNameProduct(String str_name) {
        return repository.findByNameProduct(str_name);
    }

    @Override
    public Category findByIdCategory(int id) {
        return repository.findByIdCategory(id);
    }

    @Override
    public void deleteByIdProduct(int id) {
        repository.deleteByIdProduct(id);
    }
}
