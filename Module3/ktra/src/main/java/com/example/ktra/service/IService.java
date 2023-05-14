package com.example.ktra.service;

import com.example.ktra.model.BenhNhan;

import java.util.List;

public interface IService {
    List<BenhNhan> hienThiBN();
    BenhNhan timBN(String ma);
    void  sua(BenhNhan benhNhan);
    void  xoa(String ma);
}
