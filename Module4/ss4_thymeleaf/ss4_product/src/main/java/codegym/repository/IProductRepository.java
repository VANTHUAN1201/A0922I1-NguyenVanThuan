package codegym.repository;

import codegym.model.Category;
import codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAllProduct();
    List<Category> findAllCategory();
    void create(Product product);
    void update(Product product);
    Product findByIdProduct(int id);
    List<Product> findByNameProduct(String str_name);
    Category findByIdCategory(int id);
    void deleteByIdProduct(int id);
}
