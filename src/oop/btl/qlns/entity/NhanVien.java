package oop.btl.qlns.entity;

public class NhanVien extends NhanSu {
    private String idTruongPhongQuanLi;

    public NhanVien(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        this.luongMotNgay = 100;
        this.idTruongPhongQuanLi = null;
    }

    @Override
    void tinhLuong() {
        super.tongLuong = super.luongMotNgay * super.soNgayLamViec;
    }

    public NhanVien(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, String idTruongPhongQuanLi) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        this.luongMotNgay = 100;
        this.idTruongPhongQuanLi = idTruongPhongQuanLi;
    }

    public String getIdTruongPhongQuanLi() {
        return idTruongPhongQuanLi;
    }

    public void setIdTruongPhongQuanLi(String idTruongPhongQuanLi) {
        this.idTruongPhongQuanLi = idTruongPhongQuanLi;
    }

    @Override
    public String toString() {
        return super.toString() + "ID Trưởng phòng quản lí: " + this.idTruongPhongQuanLi + "\n";
    }
}