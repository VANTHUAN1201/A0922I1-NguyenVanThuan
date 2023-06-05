package codegym.repository;

import codegym.model.Category;
import codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    public static List<Category> categoryList;
    public static List<Product> productList;

    static {
        categoryList =new ArrayList<>();
        categoryList.add(new Category(1,"smart phone"));
        categoryList.add(new Category(2,"Laptop"));
        categoryList.add(new Category(3,"Ipad"));
        productList =new ArrayList<>();
        productList.add(new Product(1,"iphone 11",1,5,"12/05/2022","15000000"));
        productList.add(new Product(2,"iphone 12",1,5,"12/05/2022","16000000"));
        productList.add(new Product(3,"dell cccc",2,5,"12/05/2022","17500000"));
        productList.add(new Product(4,"asus ccc",2,5,"12/05/2022","18500000"));
        productList.add(new Product(5,"ipad xxx",3,5,"12/05/2022","10000000"));
        productList.add(new Product(6,"ipad ddd",3,5,"12/05/2022","8000000"));
    }



    @Override
    public List<Product> findAllProduct() {
        return productList;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p : productList) {
            if (p.getId()==(product.getId())) {
                p.setId(product.getId());
                p.setName(product.getName());
                p.setCategoryId(product.getCategoryId());
                p.setQuantity(product.getQuantity());
                p.setDate(product.getDate());
                p.setPrice(product.getPrice());
                break;
            }
        }
    }

    @Override
    public Product findByIdProduct(int id) {
        for (Product p: productList) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByNameProduct(String str_name) {
        List<Product> list=new ArrayList<>();
        for (Product p: productList) {
            if (p.getName().contains(str_name)){
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public Category findByIdCategory(int id) {
        return categoryList.get(id);
    }

    @Override
    public void deleteByIdProduct(int id) {
        int index=0;
        for (Product p: productList) {
            if (p.getId()==id){
                break;
            }
            index++;
        }
        productList.remove(index);
    }
}
