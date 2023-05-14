package com.example.hokhau.model;

import java.util.Date;

public class ThanhVien {
    String cmnd;
    String ten;
    String ngSinh;
    String maHk;

    public ThanhVien() {
    }

    public ThanhVien(String cmnd, String ten, String ngSinh, String maHk) {
        this.cmnd = cmnd;
        this.ten = ten;
        this.ngSinh = ngSinh;
        this.maHk = maHk;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(String ngSinh) {
        this.ngSinh = ngSinh;
    }

    public String getMaHk() {
        return maHk;
    }

    public void setMaHk(String maHk) {
        this.maHk = maHk;
    }
}
