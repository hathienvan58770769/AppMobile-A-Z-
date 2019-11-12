package hathienvan.firstapplication.androidwebservice;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int Id, NamSinh;
    private String HoTen, DiaChi;

    public SinhVien(int id, String hoTen, int namSinh, String diaChi) {
        Id = id;
        NamSinh = namSinh;
        HoTen = hoTen;
        DiaChi = diaChi;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
