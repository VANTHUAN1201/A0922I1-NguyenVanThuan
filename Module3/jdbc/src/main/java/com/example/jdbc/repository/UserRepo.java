package com.example.jdbc.repository;

import com.example.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements IUserRepo{
    @Override
    public List<User> findAll() {
        Connection connection  =DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> userList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select * from user");
                resultSet=statement.executeQuery();
                User user=null;
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String country=resultSet.getString("country");
                    user=new User(id,name,email,country);
                    userList.add(user);
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

        return userList;
    }

    @Override
    public User findById(int id) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        User user=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select id,name,email,country from user where id =?");
                statement.setInt(1,id);
                resultSet=statement.executeQuery();

                while (resultSet.next()){
                    String name=resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String country=resultSet.getString("country");
                    user=new User(id,name,email,country);
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

        return user;
    }

    @Override
    public void save(User user) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement(
                        "insert into user(name,email,country) value(?,?,?)");
                statement.setString(1,user.getName());
                statement.setString(2,user.getEmail());
                statement.setString(3,user.getCountry());
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
    public void edit(User user) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null) {
            try {
                statement = connection.prepareStatement(
                        "update user set name = ?,email= ?, country =? where id = ?;");
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, user.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
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
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null) {
            try {
                statement = connection.prepareStatement(
                        "delete from user where id = ?;");
                statement.setInt(1,id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
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
    public List<User> findByCountry(String str) {
        Connection connection  =DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> userList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select * from user where country like ?");
                statement.setString(1,"%"+str+"%");
                resultSet=statement.executeQuery();
                User user=null;
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String country=resultSet.getString("country");
                    user=new User(id,name,email,country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public List<User> ascendingName() {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> userList=new ArrayList<>();
        if (connection!=null){
            try {
                statement=connection.prepareStatement("select * from user order by name asc;");
                resultSet=statement.executeQuery();
                User user=null;
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String country=resultSet.getString("country");
                    user=new User(id,name,email,country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public List<User> descendingName() {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> userList=new ArrayList<>();
        if (connection!=null){
            try {
                statement=connection.prepareStatement("select * from user order by name desc;");
                resultSet=statement.executeQuery();
                User user=null;
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String country=resultSet.getString("country");
                    user=new User(id,name,email,country);
                    userList.add(user);
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

        return userList;
    }

}
