package hathienvan.firstapplication.oop;

public class SinhVien {
    String HoTen, DiaChi;
    int NamSinh;

    public SinhVien(String hoTen, String diaChi, int namSinh) {
        HoTen = hoTen;
        DiaChi = diaChi;
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

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }
}
