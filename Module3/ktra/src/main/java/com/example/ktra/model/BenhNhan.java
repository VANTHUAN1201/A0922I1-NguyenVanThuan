package com.example.ktra.model;

public class BenhNhan {
    String maBenhNhan;
    String tenBenhNhan;
    String ngayNhap;
    String ngayRa;
    String liDo;
    String maBenhAn;

    public BenhNhan() {
    }

    public BenhNhan(String maBenhNhan, String tenBenhNhan, String ngayNhap, String ngayRa, String liDo, String maBenhAn) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhap = ngayNhap;
        this.ngayRa = ngayRa;
        this.liDo = liDo;
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }
}
