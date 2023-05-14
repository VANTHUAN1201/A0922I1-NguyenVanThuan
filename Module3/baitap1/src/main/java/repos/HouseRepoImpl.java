package repos;

import entities.House;
import entities.HouseDao;
import entities.Person;
import utils.ConnectDB;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseRepoImpl implements IRepo<HouseDao>{

    @Override
    public List<HouseDao> findAll(String searchName, String index) {
        String findAll = "select * from house where hhName like concat('%',?,'%') limit ?, 5;";
        int offset = (Integer.parseInt(index) - 1) * 5;
        List<HouseDao> list = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findAll)) {
            statement.setString(1, searchName);
            statement.setInt(2, offset);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("hhName");
                Date date = rs.getDate("hhDate");
                String address = rs.getString("address");
                list.add(new HouseDao(id, name, date, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public HouseDao findById(String id) {
        String findById = "select * from house where id = ?;";
        HouseDao houseDao = null;
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findById)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            String name = rs.getString("hhName");
            Date date = rs.getDate("hhDate");
            String address = rs.getString("address");
            houseDao = new HouseDao(id, name, date, address);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return houseDao;
    }

    @Override
    public void create(HouseDao house) {

    }

    @Override
    public void update(HouseDao house) {
        String updateHouse = "update house set hhName = ?, hhDate = ?, address = ? where id = ?;";
        PreparedStatement statement = null;
        try (Connection connection = ConnectDB.getConnect()) {
            statement = connection.prepareStatement(updateHouse);
            statement.setString(1, house.getHhName());
            statement.setDate(2, house.getHhDate());
            statement.setString(3, house.getAddress());
            statement.setString(4, house.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public int countItem() {
        String countItem = "select count(*) from house;";
        int items = 0;
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(countItem)) {
            ResultSet rs = statement.executeQuery();
            rs.next();
            items = rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

}
