package oop.btl.qlns.entity;

public class GiamDoc extends NhanSu {
    private int coPhan;

    public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, int coPhan) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        super.luongMotNgay = 300;
        this.coPhan = coPhan;
    }

    @Override
    void tinhLuong() {
        super.tongLuong = super.luongMotNgay * super.soNgayLamViec;
    }

    public int getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(int coPhan) {
        this.coPhan = coPhan;
    }

    @Override
    public String toString() {
        return super.toString() + "Cổ phần: " + this.coPhan + "\n";
    }
}
