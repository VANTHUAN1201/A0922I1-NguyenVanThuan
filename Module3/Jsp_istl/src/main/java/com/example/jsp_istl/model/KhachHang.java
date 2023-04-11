package com.example.jsp_istl.model;


public class KhachHang {
    private String ten;
    private String ngSinh;
    private String diaChi;
    private String anh;

    public KhachHang() {
    }

    public KhachHang(String ten, String ngSinh, String diaChi, String anh) {
        this.ten = ten;
        this.ngSinh = ngSinh;
        this.diaChi = diaChi;
        this.anh = anh;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
