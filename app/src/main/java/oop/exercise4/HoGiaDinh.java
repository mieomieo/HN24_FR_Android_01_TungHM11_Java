package oop.exercise4;

import java.util.ArrayList;

public class HoGiaDinh {
    private int soThanhVien;
    private int soNha;
    private ArrayList<Nguoi> danhSachThanhVien;

    public HoGiaDinh(int soThanhVien, int soNha) {
        this.soThanhVien = soThanhVien;
        this.soNha = soNha;
        danhSachThanhVien = new ArrayList<>();
    }

    public void themNguoi(Nguoi nguoi) {
        danhSachThanhVien.add(nguoi);
    }

    public void hienThiThongTin() {
        System.out.println("Số nhà: " + soNha);
        System.out.println("Số thành viên: " + soThanhVien);
        System.out.println("Danh sách các thành viên trong gia đình:");
        for (Nguoi nguoi : danhSachThanhVien) {
            System.out.println("Họ tên: " + nguoi.getHoTen() + ", Tuổi: " + nguoi.getTuoi() +
                    ", Nghề nghiệp: " + nguoi.getNgheNghiep() + ", Số CMND: " + nguoi.getSoCMND());
        }
    }
}
