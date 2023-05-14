package com.example.hokhau.service;

import com.example.hokhau.model.HoKhau;
import com.example.hokhau.model.ThanhVien;
import com.example.hokhau.repository.IRepo;
import com.example.hokhau.repository.RepoImpl;

import java.util.List;

public class ServiceImpl implements IService{
    IRepo repo=new RepoImpl();

    @Override
    public List<HoKhau> findAllHK() {
        return repo.findAllHK();
    }

    @Override
    public List<ThanhVien> findAllTV() {
        return null;
    }

    @Override
    public List<ThanhVien> countTV() {
        return null;
    }

    @Override
    public HoKhau findMaHK(String ma) {
        return repo.findMaHK(ma);
    }

    @Override
    public void edit(HoKhau hoKhau) {
        repo.edit(hoKhau);
    }

    @Override
    public List<ThanhVien> showTV(String ma) {
        return repo.showTV(ma);
    }

}
