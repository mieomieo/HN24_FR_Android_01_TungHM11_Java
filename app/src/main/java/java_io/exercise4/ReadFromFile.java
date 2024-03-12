package java_io.exercise4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java_io.Constant;

public class ReadFromFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Constant.PROJECT_PATH+"exercise4\\nhanvien.txt"))) {
            String line;
            System.out.println("Thông tin các nhân viên:");
            System.out.println("--------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-5s | %-10s |\n", "Mã NV", "Họ và tên", "Tuổi", "Lương");
            System.out.println("--------------------------------------------------------------");
            while ((line = reader.readLine()) != null) {
                String[] info = line.split("\\s+");
                String maNV = info[0];
                String hoTen = info[1];
                int tuoi = Integer.parseInt(info[2]);
                float luong = Float.parseFloat(info[3]);
                System.out.printf("| %-10s | %-20s | %-5d | %-10.2f |\n", maNV, hoTen, tuoi, luong);
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc từ tệp: " + e.getMessage());
        }
    }
}
