package com.example.mvc.repository;

import com.example.mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements IproductRepo {
    static List<Product> productList;
    static {
        productList=new ArrayList<>();
        productList.add(new Product(1,"ip6","iphone",7000000,""));
        productList.add(new Product(2,"ip7","iphone",8000000,""));
        productList.add(new Product(3,"ip8","iphone",8500000,""));
        productList.add(new Product(4,"ip10","iphone",9000000,""));
        productList.add(new Product(5,"ip11","iphone",9200000,""));
        productList.add(new Product(6,"ip12","iphone",12000000,""));
        productList.add(new Product(7,"ip13","iphone",13000000,""));
        productList.add(new Product(8,"ip14","iphone",14000000,""));
        productList.add(new Product(9,"vivo y11","vivo",3000000,""));
        productList.add(new Product(10,"vivo y21","vivo",5500000,""));
        productList.add(new Product(11,"sam sung a33","samsung",4500000,""));
        productList.add(new Product(12,"sam sung a34","samsung",5500000,""));
        productList.add(new Product(13,"sam sung a35","sam sum",6000000,""));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findName(String name) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void edit(int id, Product product) {

    }
    @Override
    public void remove(int id) {

    }
}
