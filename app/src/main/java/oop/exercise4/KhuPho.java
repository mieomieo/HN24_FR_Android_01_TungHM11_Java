package oop.exercise4;

import java.util.ArrayList;

public class KhuPho {
    private ArrayList<HoGiaDinh> danhSachHoGiaDinh;

    public KhuPho() {
        danhSachHoGiaDinh = new ArrayList<>();
    }

    public void themHoGiaDinh(HoGiaDinh hoGiaDinh) {
        danhSachHoGiaDinh.add(hoGiaDinh);
    }

    public void hienThiThongTinKhuPho() {
        System.out.println("Thông tin các hộ gia đình trong khu phố:");
        for (HoGiaDinh hoGiaDinh : danhSachHoGiaDinh) {
            hoGiaDinh.hienThiThongTin();
            System.out.println("----------------------------------");
        }
    }
}
