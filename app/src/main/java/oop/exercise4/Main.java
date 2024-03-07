package oop.exercise4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KhuPho khuPho = new KhuPho();

        System.out.print("Nhập số lượng hộ dân: ");
        int soLuongHoDan = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < soLuongHoDan; i++) {
            System.out.println("Nhập thông tin cho hộ gia đình thứ " + (i + 1) + ":");
            System.out.print("Nhập số nhà: ");
            int soNha = scanner.nextInt();
            System.out.print("Nhập số thành viên trong gia đình: ");
            int soThanhVien = scanner.nextInt();
            scanner.nextLine();

            HoGiaDinh hoGiaDinh = new HoGiaDinh(soThanhVien, soNha);

            for (int j = 0; j < soThanhVien; j++) {
                System.out.println("Nhập thông tin cho thành viên thứ " + (j + 1) + ":");
                System.out.print("Họ tên: ");
                String hoTen = scanner.nextLine();
                System.out.print("Tuổi: ");
                int tuoi = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng new line
                System.out.print("Nghề nghiệp: ");
                String ngheNghiep = scanner.nextLine();
                System.out.print("Số CMND: ");
                int soCMND = scanner.nextInt();

                Nguoi nguoi = new Nguoi(hoTen, tuoi, ngheNghiep, soCMND);
                hoGiaDinh.themNguoi(nguoi);
            }

            khuPho.themHoGiaDinh(hoGiaDinh);
        }

        khuPho.hienThiThongTinKhuPho();
    }
}



