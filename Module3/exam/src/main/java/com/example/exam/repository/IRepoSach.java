package com.example.exam.repository;

import com.example.exam.model.HocSinh;
import com.example.exam.model.Sach;
import com.example.exam.model.TheMuonSach;

import java.util.List;

public interface IRepoSach {
    List<Sach> hienThiSach();
    List<HocSinh> hienThiHS();
    List<TheMuonSach> hienThiMuonSach();
    Sach findMaSach(String ma);
    void  muonSach(TheMuonSach theMuonSach);

}
