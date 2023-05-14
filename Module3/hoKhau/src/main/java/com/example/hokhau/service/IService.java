package com.example.hokhau.service;

import com.example.hokhau.model.HoKhau;
import com.example.hokhau.model.ThanhVien;

import java.util.List;

public interface IService {
    List<HoKhau> findAllHK();
    List<ThanhVien> findAllTV();
    List<ThanhVien> countTV();
    HoKhau findMaHK(String ma);
    void edit(HoKhau hoKhau);
    List<ThanhVien> showTV(String ma);
}
