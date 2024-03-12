package java_io.exercise4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java_io.Constant;

public class WriteToFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter(Constant.PROJECT_PATH+"exercise4\\nhanvien.txt")) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 1; i <= 3; i++) {
                System.out.println("Nhập thông tin cho nhân viên thứ " + i + ":");
                System.out.print("Mã nhân viên: ");
                String maNV = scanner.nextLine().trim();
                System.out.print("Họ tên: ");
                String hoTen = scanner.nextLine().replaceAll("\\s+", "").trim();
                System.out.print("Tuổi: ");
                int tuoi = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Lương: ");
                float luong = Float.parseFloat(scanner.nextLine().trim());
                NhanVien nhanVien = new NhanVien(maNV,hoTen,tuoi,luong);
                String nhanVienString = nhanVien.getMaNV() + " " + nhanVien.getHoTen() + " " + nhanVien.getTuoi() + " " + nhanVien.getLuong();
                writer.write(nhanVienString + "\n");
            }
            System.out.println("Đã ghi thông tin nhân viên vào tệp nhanvien.txt");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }
    }

    }

