package com.example.hokhau.repository;

import com.example.hokhau.model.HoKhau;
import com.example.hokhau.model.ThanhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepoImpl implements IRepo {
    @Override
    public List<HoKhau> findAllHK() {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<HoKhau> hokhauList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select hk.maHk, tenChuHo,ngaylap,diaChi,count(tv.maHk) as sl from hokhau hk\n" +
                        "join thanhvien tv on hk.maHk=tv.maHk group by tv.maHk;");
                resultSet=statement.executeQuery();
                HoKhau hoKhau=null;
                while (resultSet.next()){
                    String maHk=resultSet.getString("maHk");
                    String tenChuHo=resultSet.getString("tenChuHo");
                    String ngaylap=resultSet.getString("ngaylap");
                    String diaChi=resultSet.getString("diaChi");
                    int sl=resultSet.getInt("sl");
                    hoKhau=new HoKhau(maHk,tenChuHo,sl,ngaylap,diaChi);
                    hokhauList.add(hoKhau);
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
        return hokhauList;
    }

    @Override
    public List<ThanhVien> findAllTV() {
        return null;
    }

    @Override
    public List<ThanhVien> showTV(String ma) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<ThanhVien> thanhVienList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select *from thanhvien where maHk like ?;");
                statement.setString(1,ma);
                resultSet=statement.executeQuery();
                ThanhVien thanhVien=null;
                while (resultSet.next()){
                    String cmnd=resultSet.getString("cmnd");
                    String ten=resultSet.getString("ten");
                    String ngSinh=resultSet.getString("ngSinh");
                    String maHk=resultSet.getString("maHk");
                    thanhVien=new ThanhVien(cmnd,ten,ngSinh,maHk);
                    thanhVienList.add(thanhVien);
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
        return thanhVienList;
    }

    @Override
    public HoKhau findMaHK(String ma) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        HoKhau hoKhau=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select hk.maHk, tenChuHo,ngaylap,diaChi,count(tv.maHk) as sl from hokhau hk\n" +
                        "join thanhvien tv on hk.maHk=tv.maHk where hk.maHk like ? " +
                        "group by tv.maHk;");
                statement.setString(1,ma);
                resultSet=statement.executeQuery();
                while (resultSet.next()){
                    String maHk=resultSet.getString("maHk");
                    String tenChuHo=resultSet.getString("tenChuHo");
                    int sl=resultSet.getInt("sl");
                    String ngaylap=resultSet.getString("ngaylap");
                    String diaChi=resultSet.getString("diaChi");
                    hoKhau=new HoKhau(maHk,tenChuHo,sl,ngaylap,diaChi);
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
        return hoKhau;
    }

    @Override
    public void edit(HoKhau hoKhau) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try {
                statement=connection.prepareStatement("update hokhau set tenChuHo=?,ngaylap=?,diaChi=? where maHk like ?;");
                statement.setString(1,hoKhau.getTenChuHo());
                statement.setString(2,hoKhau.getNgaylap());
                statement.setString(3,hoKhau.getDiaChi());
                statement.setString(4,hoKhau.getMaHk());
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
}
