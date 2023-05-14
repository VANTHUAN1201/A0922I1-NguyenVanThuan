package com.example.jdbc_procedure.repository;

import com.example.jdbc_procedure.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements IUserRepo {

    @Override
    public List<User> findAll() {
        Connection connection=DBConnection.getConnection();
        CallableStatement statement=null;
        ResultSet resultSet=null;
        List<User> list=new ArrayList<>();
        User user=null;
        if (connection!=null){
            try{
                statement=connection.prepareCall("call search_all();");
                resultSet= statement.executeQuery();

                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String country=resultSet.getString("country");
                    user=new User(id,name,email,country);
                    list.add(user);
                }
            } catch (SQLException e) {
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
        return list;
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
    public void edit(User user) {
        Connection connection=DBConnection.getConnection();
        CallableStatement statement=null;
        try{
            statement=connection.prepareCall("call update_user(?,?,?,?);");
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getCountry());
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

    @Override
    public void remove(int id) {
        Connection connection=DBConnection.getConnection();
        CallableStatement statement=null;
        if (connection!=null){
            try{
                statement=connection.prepareCall("call delete_user(?);");
                statement.setInt(1,id);
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
}
