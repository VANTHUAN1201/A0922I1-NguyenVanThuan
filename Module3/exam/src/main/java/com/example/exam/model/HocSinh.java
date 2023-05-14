package com.example.exam.model;

public class HocSinh {
    String maHS;
    String tenHS;
    String lop;

    public HocSinh() {
    }

    public HocSinh(String maHS, String tenHS, String lop) {
        this.maHS = maHS;
        this.tenHS = tenHS;
        this.lop = lop;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
