package java_io.exercise4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java_io.Constant;

public class WriteToObject {
    public static void main(String[] args) {
        NhanVien[] nhanViens = new NhanVien[3];
        nhanViens[0] = new NhanVien("1", "Hoang Manh Tung", 30, 1000);
        nhanViens[1] = new NhanVien("2", "Dinh Van Lam", 25, 800);
        nhanViens[2] = new NhanVien("3", "Lung Thi Linh", 35, 1200);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(Constant.PROJECT_PATH+"exercise4\\nhanvien.bin"))) {
            outputStream.writeObject(nhanViens);
            System.out.println("Đã ghi mảng nhân viên vào tệp nhanvien.bin");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }
    }
}
