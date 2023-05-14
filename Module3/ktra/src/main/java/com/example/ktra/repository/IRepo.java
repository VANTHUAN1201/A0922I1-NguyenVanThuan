package com.example.ktra.repository;

import com.example.ktra.model.BenhNhan;

import java.util.List;

public interface IRepo {
    List<BenhNhan> hienThiBN();
    BenhNhan timBN(String ma);
    void  sua(BenhNhan benhNhan);
    void  xoa(String ma);
}
