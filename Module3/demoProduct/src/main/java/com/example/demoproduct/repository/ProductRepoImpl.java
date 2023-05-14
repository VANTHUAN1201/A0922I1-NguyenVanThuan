package com.example.demoproduct.repository;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.model.Product;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements IProductRepo{

    @Override
    public List<Product> findAllProduct(){
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Product> productList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select *from product");
                resultSet=statement.executeQuery();
                Product product=null;
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    int price=resultSet.getInt("price");
                    int amount=resultSet.getInt("amount");
                    int id_category=resultSet.getInt("id_category");
                    product=new Product(id,name,price,amount,id_category);
                    productList.add(product);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
               try {
                   resultSet.close();
                   statement.close();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
               DBConnection.close();
            }
        }
        return productList;
    }

    @Override
    public List<Category> findAllCategory() {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Category> categoryList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select *from category;");
                resultSet=statement.executeQuery();
                Category category=null;
                while (resultSet.next()){
                    int id_category=resultSet.getInt("id_category");
                    String category_name=resultSet.getString("category_name");
                    category=new Category(id_category,category_name);
                    categoryList.add(category);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return categoryList;
    }

    @Override
    public Product findIdProduct(int id) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Product product=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select id,name,price,amount,id_category from product where id =?");
                statement.setInt(1,id);
                resultSet=statement.executeQuery();
                while (resultSet.next()){
                    String name=resultSet.getString("name");
                    int price=resultSet.getInt("price");
                    int amount=resultSet.getInt("amount");
                    int id_category=resultSet.getInt("id_category");
                    product=new Product(id,name,price,amount,id_category);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return product;
    }

    @Override
    public Category findIdCategory(int id_category) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Category category=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select id_category,category_name from product where id_category =?");
                statement.setInt(1,id_category);
                resultSet=statement.executeQuery();
                while (resultSet.next()){
                    String category_name=resultSet.getString("category_name");
                    category=new Category(id_category,category_name);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return category;
    }

    @Override
    public void save(Product product) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement(
                        "insert into product(name,price,amount,id_category) value(?,?,?,?)");
                statement.setString(1,product.getName());
                statement.setInt(2,product.getPrice());
                statement.setInt(3,product.getAmount());
                statement.setInt(4,product.getId_category());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void edit(Product product) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try {
                statement=connection.prepareStatement("update product set name=?,price=?,amount=?,id_category=? where id=?;");
                statement.setString(1,product.getName());
                statement.setInt(2,product.getPrice());
                statement.setInt(3,product.getAmount());
                statement.setInt(4,product.getId_category());
                statement.setInt(5,product.getId());
                statement.executeUpdate();

            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();

            }
        }

    }

    @Override
    public void remove(int id) {
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("delete from product where id=?;");
                statement.setInt(1,id);
                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Product> findName(String str) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Product> list=new ArrayList<>();
        if (connection!=null){
            try {
                statement=connection.prepareStatement("select * from product where name like ?");
                statement.setString(1,"%"+str +"%");
                resultSet=statement.executeQuery();
                Product product=null;
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    int price=resultSet.getInt("price");
                    int amount=resultSet.getInt("amount");
                    int id_category=resultSet.getInt("id_category");
                    product=new Product(id,name,price,amount,id_category);
                    list.add(product);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    statement.close();
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return list;
    }
}
