package com.example.exam.repository;

import com.example.exam.model.HocSinh;
import com.example.exam.model.Sach;
import com.example.exam.model.TheMuonSach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RePoSachImpl implements IRepoSach{
    @Override
    public List<Sach> hienThiSach() {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Sach> sachList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("SELECT s.maSach,tenSach,tacGia,moTa,(sl-ifnull((ms.maSach),0)) as sl FROM sach s\n" +
                        "left join themuonsach ms on s.maSach=ms.maSach\n" +
                        "group by s.maSach;\n");
                resultSet=statement.executeQuery();
                Sach sach=null;
                while (resultSet.next()){
                    String maSach=resultSet.getString("maSach");
                    String tenSach=resultSet.getString("tenSach");
                    String tacGia=resultSet.getString("tacGia");
                    String moTa=resultSet.getString("moTa");
                    int sl=resultSet.getInt("sl");

                    sach=new Sach(maSach,tenSach,tacGia,moTa,sl);
                    sachList.add(sach);
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
        return sachList;
    }

    @Override
    public List<HocSinh> hienThiHS() {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<HocSinh> hocSinhList=new ArrayList<>();
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select * from hocsinh");
                resultSet=statement.executeQuery();
                HocSinh hocSinh=null;
                while (resultSet.next()){
                    String maHS=resultSet.getString("maHS");
                    String tenHS=resultSet.getString("tenHS");
                    String lop=resultSet.getString("lop");
                    hocSinh=new HocSinh(maHS,tenHS,lop);
                    hocSinhList.add(hocSinh);
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
        return hocSinhList;
    }

    @Override
    public List<TheMuonSach> hienThiMuonSach() {
        return null;
    }

    @Override
    public Sach findMaSach(String ma) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Sach sach=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement("select * from sach where maSach like ?; ");
                statement.setString(1,ma);
                resultSet=statement.executeQuery();
                while (resultSet.next()){
                    String maSach=resultSet.getString("maSach");
                    String tenSach=resultSet.getString("tenSach");
                    String tacGia=resultSet.getString("tacGia");
                    String moTa=resultSet.getString("moTa");
                    int sl=resultSet.getInt("sl");
                    sach=new Sach(maSach,tenSach,tacGia,moTa,sl);
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
        return sach;
    }

    @Override
    public void muonSach(TheMuonSach theMuonSach) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try{
                statement=connection.prepareStatement(
                        "insert into themuonsach(maMuonSach,maSach,maHS,ngayMuon,ngayTra) value(?,?,?,?,?)");
                statement.setString(1,theMuonSach.getMaMuonSach());
                statement.setString(2,theMuonSach.getMaSach());
                statement.setString(3,theMuonSach.getMaHS());
                statement.setString(4,theMuonSach.getNgayMuon());
                statement.setString(5,theMuonSach.getNgayTra());
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
