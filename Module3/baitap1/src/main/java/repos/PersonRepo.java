package repos;

import entities.House;
import entities.HouseDao;
import entities.Person;
import utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepo {
    public List<Person> findAll() {
        String findAll = "select * from person ;";
        List<Person> list = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findAll)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("bod");
                String hhId = rs.getString("hhId");
                list.add(new Person(id, name, date, hhId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public int countPersonInHouse(String id){
        String countPerson = "select count(*) from person where hhId = ?;";
        int count = 0;
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(countPerson)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            count = rs.getInt(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }


    public String findByIdHH(String id) {
        StringBuilder result = new StringBuilder();
        String findAllPersonInHouse = "select * from person where hhId = ?;";
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findAllPersonInHouse)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                result.append(name).append("<br>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return String.valueOf(result);
    }

    public void update(String oldName, String updateName){
        String updatePerson = "update person set name = ? where name = ?;";
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(updatePerson)) {
            statement.setString(1, updateName);
            statement.setString(2, oldName);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
