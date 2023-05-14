package com.example.exam.service;

import com.example.exam.model.HocSinh;
import com.example.exam.model.Sach;
import com.example.exam.model.TheMuonSach;
import com.example.exam.repository.IRepoSach;
import com.example.exam.repository.RePoSachImpl;

import java.util.List;

public class ServiceSachImpl implements  IServiceSach{
    IRepoSach repoSach=new RePoSachImpl();
    @Override
    public List<Sach> hienThiSach() {
        return repoSach.hienThiSach();
    }

    @Override
    public List<HocSinh> hienThiHS() {
        return repoSach.hienThiHS();
    }

    @Override
    public List<TheMuonSach> hienThiMuonSach() {
        return null;
    }

    @Override
    public Sach findMaSach(String ma) {
        return repoSach.findMaSach(ma);
    }

    @Override
    public void muonSach(TheMuonSach theMuonSach) {
        repoSach.muonSach(theMuonSach);
    }
}
