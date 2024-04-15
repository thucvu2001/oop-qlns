package oop.btl.qlns.entity;

public abstract class NhanSu {
    protected final String maSo;
    protected final String hoTen;
    protected String soDienThoai;
    protected int soNgayLamViec;
    protected long luongMotNgay;
    protected long tongLuong;

    public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soNgayLamViec = soNgayLamViec;
    }

    abstract void tinhLuong();

    public String getMaSo() {
        return maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public long getLuongMotNgay() {
        return luongMotNgay;
    }

    public void setLuongMotNgay(long luongMotNgay) {
        this.luongMotNgay = luongMotNgay;
    }

    public long getTongLuong() {
        tinhLuong();
        return this.tongLuong;
    }

    @Override
    public String toString() {
        return "Mã số: " + this.maSo + "\n"
                + "Họ tên: " + this.hoTen + "\n"
                + "Số điện thoại: " + this.soDienThoai + "\n"
                + "Số ngày làm việc: " + this.soNgayLamViec + "\n"
                + "Lương 1 ngày: " + this.luongMotNgay + "\n"
                + "Tổng lương: " + this.getTongLuong() + "\n";
    }
}
