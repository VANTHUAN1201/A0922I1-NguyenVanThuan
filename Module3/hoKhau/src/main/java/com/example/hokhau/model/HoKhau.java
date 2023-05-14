package com.example.hokhau.model;


import java.sql.Date;

public class HoKhau {
    String maHk;
    String tenChuHo;
    int sl;
    String ngaylap;
    String diaChi;

    public HoKhau() {
    }

    public HoKhau(String maHk, String tenChuHo, int sl, String ngaylap, String diaChi) {
        this.maHk = maHk;
        this.tenChuHo = tenChuHo;
        this.sl = sl;
        this.ngaylap = ngaylap;
        this.diaChi = diaChi;
    }

    public HoKhau(String maHk, String tenChuHo, String ngaylap, String diaChi) {
        this.maHk = maHk;
        this.tenChuHo = tenChuHo;
        this.ngaylap = ngaylap;
        this.diaChi = diaChi;
    }

    public String getMaHk() {
        return maHk;
    }

    public void setMaHk(String maHk) {
        this.maHk = maHk;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngayLap) {
        this.ngaylap = ngaylap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
