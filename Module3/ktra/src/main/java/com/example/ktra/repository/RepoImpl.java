package com.example.ktra.repository;

import com.example.ktra.model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoImpl implements IRepo {
    @Override
    public List<BenhNhan> hienThiBN() {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<BenhNhan> benhNhanList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select ba.maBenhAn,bn.maBenhNhan,bn.tenBenhNhan,bn.ngayNhap,bn.ngayRa,bn.liDo from benhan ba\n" +
                        "join benhnhan bn on ba.maBenhAn=bn.maBenhAn;");
                resultSet=statement.executeQuery();
                BenhNhan benhNhan=null;
                while (resultSet.next()){
                    String maBenhAn=resultSet.getString("maBenhAn");
                    String maBenhNhan=resultSet.getString("maBenhNhan");
                    String tenBenhNhan=resultSet.getString("tenBenhNhan");
                    String ngayNhap=resultSet.getString("ngayNhap");
                    String ngayRa=resultSet.getString("ngayRa");
                    String liDo=resultSet.getString("liDo");

                    benhNhan=new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhap,ngayRa,liDo,maBenhAn);
                    benhNhanList.add(benhNhan);
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
        return benhNhanList;
    }

    @Override
    public BenhNhan timBN(String ma) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        BenhNhan benhNhan=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select ba.maBenhAn,bn.maBenhNhan,bn.tenBenhNhan,bn.ngayNhap,bn.ngayRa,bn.liDo from benhan ba\n" +
                        "join benhnhan bn on ba.maBenhAn=bn.maBenhAn  where bn.maBenhNhan like ?;");

                statement.setString(1,ma);
                resultSet=statement.executeQuery();
                while (resultSet.next()){
                    String maBenhAn=resultSet.getString("maBenhAn");
                    String maBenhNhan=resultSet.getString("maBenhNhan");
                    String tenBenhNhan=resultSet.getString("tenBenhNhan");
                    String ngayNhap=resultSet.getString("ngayNhap");
                    String ngayRa=resultSet.getString("ngayRa");
                    String liDo=resultSet.getString("liDo");
                    benhNhan=new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhap,ngayRa,liDo,maBenhAn);
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
        return benhNhan;
    }

    @Override
    public void sua(BenhNhan benhNhan) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try {
                statement=connection.prepareStatement("update benhnhan set tenBenhNhan=?,ngayNhap=?,ngayRa=?,liDo=? where maBenhNhan=?;");
                statement.setString(1,benhNhan.getTenBenhNhan());
                statement.setString(2,benhNhan.getNgayNhap());
                statement.setString(3,benhNhan.getNgayRa());
                statement.setString(4,benhNhan.getLiDo());
                statement.setString(5,benhNhan.getMaBenhNhan());
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
    public void xoa(String ma) {
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("delete from benhnhan where maBenhNhan=?;");
                statement.setString(1,ma);
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
