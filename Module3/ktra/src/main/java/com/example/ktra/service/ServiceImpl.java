package com.example.ktra.service;

import com.example.ktra.model.BenhNhan;
import com.example.ktra.repository.IRepo;
import com.example.ktra.repository.RepoImpl;

import java.util.List;

public class ServiceImpl implements IService{
    IRepo repo=new RepoImpl();
    @Override
    public List<BenhNhan> hienThiBN() {
        return repo.hienThiBN();
    }

    @Override
    public BenhNhan timBN(String ma) {
        return repo.timBN(ma);
    }

    @Override
    public void sua(BenhNhan benhNhan) {
        repo.sua(benhNhan);
    }

    @Override
    public void xoa(String ma) {
        repo.xoa(ma);

    }
}
