package com.example.exam.service;

import com.example.exam.model.HocSinh;
import com.example.exam.model.Sach;
import com.example.exam.model.TheMuonSach;

import java.util.List;

public interface IServiceSach {
    List<Sach> hienThiSach();
    List<HocSinh> hienThiHS();
    List<TheMuonSach> hienThiMuonSach();
    Sach findMaSach(String ma);
    void  muonSach(TheMuonSach theMuonSach);
}
