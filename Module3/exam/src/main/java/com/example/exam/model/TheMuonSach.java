package com.example.exam.model;

public class TheMuonSach{
    String maMuonSach;
    String maSach;
    String maHS;
    Boolean trangThai;
    String ngayMuon;
    String ngayTra;

    public TheMuonSach() {
    }

    public TheMuonSach(String maMuonSach, String maSach, String maHS, Boolean trangThai, String ngayMuon, String ngayTra) {
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.maHS = maHS;
        this.trangThai = trangThai;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }
    public TheMuonSach(String maMuonSach, String maSach, String maHS , String ngayMuon, String ngayTra) {
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.maHS = maHS;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}
