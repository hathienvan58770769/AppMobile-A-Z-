package hathienvan.firstapplication.listviewlevel;

public class TraiCay {
    private  String Ten, MoTa;
    private int img;

    public TraiCay(String ten, String moTa, int img) {
        Ten = ten;
        MoTa = moTa;
        this.img = img;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
