package oop.btl.qlns.main;

import oop.btl.qlns.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static final Scanner sc = new Scanner(System.in);
    public static AuthManager authManager = new AuthManager();

    public static void inMenu() {
        System.out.println("============================ MENU ============================");
        System.out.println("1. Nhập thông tin công ty.");
        System.out.println("2. Phân bổ Nhân viên vào Trưởng phòng.");
        System.out.println("3. Thêm, xoá thông tin một nhân sự.");
        System.out.println("4. Xuất ra thông tin toàn bộ người trong công ty.");
        System.out.println("5. Tính và xuất tổng lương cho toàn công ty.");
        System.out.println("6. Tìm Nhân viên thường có lương cao nhất.");
        System.out.println("7. Tìm Trưởng phòng có số lượng nhân viên nhiều nhất.");
        System.out.println("8. Sắp xếp nhân viên toàn công ty theo thứ tự abc.");
        System.out.println("9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần.");
        System.out.println("10. Tìm Giám đốc có số lượng cổ phần nhiều nhất.");
        System.out.println("11. Tính và Xuất tổng thu nhập của từng giám đốc.");
        System.out.println("12. In ra lợi nhuận của công ty.");
        System.out.println("0. Đăng xuất!");
        System.out.print("NHẬP LỰA CHỌN: ");
    }


    public static long tongLuongCongTy(List<NhanSu> nhanSus) {
        long tong = 0;
        for (NhanSu x : nhanSus) {
            tong += x.getTongLuong();
        }
        return tong;
    }

    public static long loiNhuanCongTy(List<NhanSu> nhanSus, CongTy congTy) {
        return congTy.getDoanhThuThang() - tongLuongCongTy(nhanSus);
    }

    public static void main(String[] args) {
        authentication();
    }

    public static void inMenu2() {
        System.out.println("============================ AUTH ============================");
        System.out.println("1. Đăng kí.");
        System.out.println("2. Đăng nhập.");
    }

    public static void authentication() {
        inMenu2();
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                System.out.print("Nhap username: ");
                String username = sc.nextLine();
                System.out.print("Nhap password: ");
                String password = sc.nextLine();
                boolean check = authManager.register(username, password);
                if (check) {
                    System.out.println("=====> Register success");
                    authentication();
                } else {
                    authentication();
                }
                break;
            case 2:
                System.out.print("Nhap username: ");
                String username2 = sc.nextLine();
                System.out.print("Nhap password: ");
                String password2 = sc.nextLine();
                boolean check2 = authManager.login(username2, password2);
                if (check2) {
                    System.out.println("=====> Login success");
                    chucNang();
                } else {
                    System.out.println("=====> username or password is incorrect");
                    authentication();
                }
                break;
        }
    }

    public static void chucNang() {
        CongTy congTy = new CongTy();
        List<NhanSu> nhanSus = new ArrayList<>();
        List<NhanVien> nhanViens = new ArrayList<>();
        List<TruongPhong> truongPhongs = new ArrayList<>();
        List<GiamDoc> giamDocs = new ArrayList<>();
        while (true) {
            inMenu();
            int luaChon = sc.nextInt();
            sc.nextLine();
            if (luaChon == 0) {
                authManager.logout();
                authentication();
                break;
            } else if (luaChon == 1) {
                System.out.print("Nhập tên công ty: ");
                String tenCongTy = sc.nextLine();
                congTy.setTenCongTy(tenCongTy);
                System.out.print("Nhập mã số thuế: ");
                String maSoThue = sc.nextLine();
                congTy.setMaSoThue(maSoThue);
                System.out.print("Nhập doanh thu tháng: ");
                long doanhThuThang = sc.nextLong();
                congTy.setDoanhThuThang(doanhThuThang);
                System.out.println(congTy);
            } else if (luaChon == 2) {
                if (truongPhongs.isEmpty()) {
                    System.out.println("Hiện tại không có trưởng phòng nào, hãy chọn 3 để thêm nhân sự");
                } else {
                    System.out.print("Nhập mã nhân viên: ");
                    String maNhanVien = sc.nextLine();
                    System.out.print("Nhập mã trưởng phòng: ");
                    String maTruongPhong = sc.nextLine();
                    for (TruongPhong x : truongPhongs) {
                        if (x.getMaSo().equals(maTruongPhong)) {
                            x.tangNhanVienQuanLi();
                        }
                    }
                    for (NhanVien x : nhanViens) {
                        if (x.getMaSo().equals(maNhanVien)) {
                            x.setIdTruongPhongQuanLi(maTruongPhong);
                        }
                    }
                }
            } else if (luaChon == 3) { // thêm, xoá thông tin một nhân sự
                System.out.println("    Lựa chọn: ");
                System.out.println("    1. Thêm nhân viên.");
                System.out.println("    2. Thêm trưởng phòng.");
                System.out.println("    3. Thêm giám đốc.");
                System.out.println("    4. Xoá nhân sự.");
                System.out.print("    Chọn: ");
                int chon = Integer.parseInt(sc.nextLine());
                if (chon == 1) { // them nhan vien
                    System.out.print("Nhập mã số: ");
                    String maSo = sc.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String hoTen = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String soDienThoai = sc.nextLine();
                    System.out.print("Nhập số ngày làm việc: ");
                    int soNgayLamViec = sc.nextInt();
                    System.out.print("Nhập mã trưởng phòng quản lí (nếu không có thì bỏ qua): ");
                    sc.nextLine();
                    String idTruongPhongQuanLi = sc.nextLine();
                    if (idTruongPhongQuanLi.isBlank()) {
                        NhanVien nhanVien = new NhanVien(maSo, hoTen, soDienThoai, soNgayLamViec);
                        nhanViens.add(nhanVien);
                        nhanSus.add(nhanVien);
                    } else {
                        NhanVien nhanVien = new NhanVien(maSo, hoTen, soDienThoai, soNgayLamViec, idTruongPhongQuanLi);
                        nhanViens.add(nhanVien);
                        nhanSus.add(nhanVien);
                        for (TruongPhong x : truongPhongs) {
                            if (x.getMaSo().equals(idTruongPhongQuanLi)) {
                                x.tangNhanVienQuanLi();
                            }
                        }
                    }
                } else if (chon == 2) { // them truong phong
                    System.out.print("Nhập mã số: ");
                    String maSo = sc.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String hoTen = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String soDienThoai = sc.nextLine();
                    System.out.print("Nhập số ngày làm việc: ");
                    int soNgayLamViec = sc.nextInt();
                    System.out.print("Nhập số lượng nhân viên quản lí: ");
                    int soNhanVienQuanLi = sc.nextInt();
                    TruongPhong truongPhong = new TruongPhong(maSo, hoTen, soDienThoai, soNgayLamViec, soNhanVienQuanLi);
                    truongPhongs.add(truongPhong);
                    nhanSus.add(truongPhong);
                } else if (chon == 3) { // them giam doc
                    System.out.print("Nhập mã số: ");
                    String maSo = sc.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String hoTen = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String soDienThoai = sc.nextLine();
                    System.out.print("Nhập số ngày làm việc: ");
                    int soNgayLamViec = sc.nextInt();
                    System.out.print("Nhập cổ phần: ");
                    int coPhan = sc.nextInt();
                    GiamDoc giamDoc = new GiamDoc(maSo, hoTen, soDienThoai, soNgayLamViec, coPhan);
                    giamDocs.add(giamDoc);
                    nhanSus.add(giamDoc);
                } else if (chon == 4) { // xoa nhan su
                    System.out.print("Nhập mã của nhân sự cần xoá: ");
                    sc.nextLine();
                    String maNhanSu = sc.nextLine();
                    boolean tonTai = false; // để kiểm tra nhân sự cần xoá có trong danh sách nhân sự hay không
                    for (NhanSu x : nhanSus) { // duyet danh sach nhan su
                        if (x.getMaSo().equals(maNhanSu)) { // tim thay nhan su x can xoa
                            if (x instanceof TruongPhong) { // neu x la truong phong
                                for (NhanVien y : nhanViens) { // tìm nhân viên y của trưởng phòng x
                                    if (y.getIdTruongPhongQuanLi().equals(x.getMaSo())) { // tìm thấy
                                        y.setIdTruongPhongQuanLi(null); // chuyển trưởng phòng của nhân viên y thành null
                                    }
                                }
                                nhanSus.remove(x); // xoá trưởng phòng x khỏi list nhân sự
                                truongPhongs.remove(x); // xoá trưởng phòng x khỏi list trưởng phòng
                            } else if (x instanceof NhanVien) { // nếu x là nhân viên
                                if (((NhanVien) x).getIdTruongPhongQuanLi() != null && !((NhanVien) x).getIdTruongPhongQuanLi().trim().isEmpty()) { // nếu id trưởng phòng của x khác null
                                    for (TruongPhong y : truongPhongs) { // tìm trưởng phòng y của nhân viên x
                                        if (y.getMaSo().equals(((NhanVien) x).getIdTruongPhongQuanLi())) {
                                            y.giamNhanVienLi(); // giảm nhân viên của trưởng phòng y
                                        }
                                    }
                                }
                                nhanSus.remove(x); // xoá nhân viên x khỏi list nhân sự
                                nhanViens.remove(x); // xoá nhân viên x khỏi list nhân viên
                            } else if (x instanceof GiamDoc) { // nếu x là giám đốc thì xoá bình thường
                                giamDocs.remove(x);
                                nhanSus.remove(x);
                            }
                            tonTai = true;
                            System.out.print("Đã xoá\n");
                        }
                    }
                    if (!tonTai) {
                        System.out.println("Mã nhân sự không tồn tại!");
                    }
                }

            } else if (luaChon == 4) { // xuất ra thông tin toàn bộ người trong công ty
                System.out.println("    Giám đốc: ");
                for (GiamDoc x : giamDocs) {
                    System.out.println(x.toString());
                }
                System.out.println("    Trưởng phòng: ");
                for (TruongPhong x : truongPhongs) {
                    System.out.println(x.toString());
                }
                System.out.println("    Nhân viên: ");
                for (NhanVien x : nhanViens) {
                    System.out.println(x.toString());
                }
            } else if (luaChon == 5) {
                if (nhanSus.size() == 0) {
                    System.out.println("Công ty không nhân sự nào. Hãy chọn 3 để thêm nhân sự!");
                } else {
                    System.out.println("Tổng lương của toàn công ty: " + tongLuongCongTy(nhanSus));
                }
            } else if (luaChon == 6) {
                if (nhanViens.size() == 0) {
                    System.out.println("Không có nhân viên. Hãy chọn 3 để thêm nhân sự!");
                } else {
                    nhanViens.sort((o1, o2) -> {
                        if (o1.getTongLuong() > o2.getTongLuong()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                    System.out.println("Thông tin nhân viên có lương cao nhất là:");
                    System.out.println(nhanViens.get(0).toString());
                }
            } else if (luaChon == 7) {
                if (truongPhongs.size() == 0) {
                    System.out.println("Không có trưởng phòng. Hãy chọn 3 để thêm nhân sự!");
                } else {
                    truongPhongs.sort((o1, o2) -> {
                        if (o1.getSoNhanVienQuanLi() > o2.getSoNhanVienQuanLi()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                    System.out.println("Thông tin trưởng phòng có nhiều nhân viên nhất là: ");
                    System.out.println(truongPhongs.get(0).toString());
                }
            } else if (luaChon == 8) {
                if (nhanSus.isEmpty()) {
                    System.out.println("Công ty không có nhân sự. Hãy chọn 3 để thêm nhân sự!");
                } else {
                    nhanSus.sort((o1, o2) -> {
                        String firstName1 = o1.getHoTen().substring(o1.getHoTen().lastIndexOf(" " + 1));
                        String firstName2 = o2.getHoTen().substring(o2.getHoTen().lastIndexOf(" " + 1));
                        int compareName = firstName1.compareTo(firstName2);
                        if (compareName == 0) {
                            String lastName1 = o1.getHoTen().substring(0, o1.getHoTen().indexOf(" "));
                            String lastName2 = o2.getHoTen().substring(0, o2.getHoTen().indexOf(" "));
                            return lastName1.compareTo(lastName2);
                        } else {
                            return compareName;
                        }

                    });
                    System.out.println("Danh sách tên sau khi sắp xếp: ");
                    for (NhanSu x : nhanSus) {
                        System.out.println(x.getHoTen());
                    }
                }
            } else if (luaChon == 9) {
                if (nhanSus.size() == 0) {
                    System.out.println("Công ty không có nhân sự. Hãy chọn 3 để thêm nhân sự!");
                } else {
                    nhanSus.sort((o1, o2) -> {
                        if (o1.getTongLuong() > o2.getTongLuong()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                    System.out.println("Bảng lương sau khi sắp xếp giảm dần: ");
                    for (NhanSu x : nhanSus) {
                        System.out.println(x.getHoTen() + ": " + x.getTongLuong());
                    }
                }
            } else if (luaChon == 10) {
                if (giamDocs.size() == 0) {
                    System.out.println("Không có giám đốc nào. Hãy chọn 3 để thêm nhân sự!");
                } else {
                    giamDocs.sort((o1, o2) -> {
                        if (o1.getCoPhan() > o2.getCoPhan()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                    System.out.println("Thông tin giám đốc có cổ phần nhiều nhất: ");
                    System.out.println(giamDocs.get(0).toString());
                }
            } else if (luaChon == 11) {
                if (giamDocs.size() == 0) {
                    System.out.println("Không có giám đốc. Hãy chọn 3 để thêm nhân sự!");
                } else {
                    System.out.println("Thu nhập của các giám đốc: ");
                    for (GiamDoc x : giamDocs) {
                        long thuNhap = x.getTongLuong() + x.getCoPhan() * loiNhuanCongTy(nhanSus, congTy);
                        System.out.println(x.getHoTen() + ": " + thuNhap);
                    }
                }
            } else if (luaChon == 12) {
                System.out.println("Lợi nhuận của công ty: " + loiNhuanCongTy(nhanSus, congTy));
            }
        }
    }
}