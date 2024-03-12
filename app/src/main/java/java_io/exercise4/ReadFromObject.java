package java_io.exercise4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java_io.Constant;

public class ReadFromObject {
    public static void main(String[] args) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(Constant.PROJECT_PATH+"exercise4\\nhanvien.bin"))) {
            NhanVien[] arrayNhanVien = (NhanVien[]) inputStream.readObject();
            System.out.println("--------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-5s | %-10s |\n", "Mã NV", "Họ và tên", "Tuổi", "Lương");
            System.out.println("--------------------------------------------------------------");
            for (NhanVien nv : arrayNhanVien) {
                System.out.printf("| %-10s | %-20s | %-5d | %-10.2f |\n", nv.getMaNV(), nv.getHoTen(), nv.getTuoi(), nv.getLuong());
            }
            System.out.println("--------------------------------------------------------------");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Đã xảy ra lỗi khi đọc từ tệp: " + e.getMessage());
        }
    }
}
