package com.example.hokhau.repository;

import com.example.hokhau.model.HoKhau;
import com.example.hokhau.model.ThanhVien;

import java.util.List;

public interface IRepo {
    List<HoKhau> findAllHK();
    List<ThanhVien> findAllTV();
    List<ThanhVien> showTV(String ma);
    HoKhau findMaHK(String ma);
    void edit(HoKhau hoKhau);
}
