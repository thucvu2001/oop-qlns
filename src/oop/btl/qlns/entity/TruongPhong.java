package oop.btl.qlns.entity;

public class TruongPhong extends NhanSu {
    private int soNhanVienQuanLi;

    public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        super.luongMotNgay = 200;
        this.soNhanVienQuanLi = 0;
    }

    public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, int soNhanVienQuanLi) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        super.luongMotNgay = 200;
        this.soNhanVienQuanLi = soNhanVienQuanLi;
    }

    @Override
    void tinhLuong() {
        super.tongLuong = super.luongMotNgay * super.soNgayLamViec + 100 * this.soNhanVienQuanLi;
    }

    public void tangNhanVienQuanLi() {
        this.soNhanVienQuanLi += 1;
    }

    public void giamNhanVienLi() {
        this.soNhanVienQuanLi -= 1;
    }

    public int getSoNhanVienQuanLi() {
        return soNhanVienQuanLi;
    }

    public void setSoNhanVienQuanLi(int soNhanVienQuanLi) {
        this.soNhanVienQuanLi = soNhanVienQuanLi;
    }

    @Override
    public String toString() {
        return super.toString() + "Số lượng nhân viên quản lí: " + this.soNhanVienQuanLi + "\n";
    }
}
