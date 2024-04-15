package oop.btl.qlns.entity;

public class CongTy {
    private String tenCongTy;
    private String maSoThue;
    private long doanhThuThang;

    public CongTy() {

    }

    public CongTy(String tenCongTy, String maSoThue, long doanhThuThang) {
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.doanhThuThang = doanhThuThang;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public long getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(long doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    @Override
    public String toString() {
        String tmp = "Tên công ty: " + this.tenCongTy + "\n" + "Mã số thuế: " + this.maSoThue + "\n" + "Doanh thu tháng: " + this.doanhThuThang;
        return tmp;
    }

}
