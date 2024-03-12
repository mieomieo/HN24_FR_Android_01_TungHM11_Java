package java_io.exercise5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java_io.Constant;

public class Exercise5 {


    private static ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
    private static final String PATH = Constant.PROJECT_PATH + "exercise5\\sinhvien.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadDanhSachSinhVienTuFile();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên theo mã");
            System.out.println("3. Xóa sinh viên theo mã");
            System.out.println("4. Sắp xếp sinh viên theo họ tên");
            System.out.println("5. Sắp xếp sinh viên theo điểm trung bình");
            System.out.println("6. Hiển thị thông tin tất cả sinh viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Lựa chọn menu: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    themSinhVien();
                    break;
                case "2":
                    suaSinhVien();
                    break;
                case "3":
                    xoaSinhVien();
                    break;
                case "4":
                    sapXepTheoHoTen();
                    break;
                case "5":
                    sapXepTheoDiemTB();
                    break;
                case "6":
                    hienThiThongTinTatCaSinhVien();
                    break;
                case "0":
                    luuFileVaThoat();
                    System.out.println("Thoát chương trình");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

    }

    private static void loadDanhSachSinhVienTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String dong;
            while ((dong = reader.readLine()) != null) {
                String[] thongTin = dong.split("\\s+");
                try {
                    String maSV = thongTin[0];
                    String hoTen = thongTin[1];
                    String diaChi = thongTin[3];
                    int tuoi = Integer.parseInt(thongTin[2]);
                    double diemTB = Double.parseDouble(thongTin[4]);
                    SinhVien sinhVien = new SinhVien(maSV, hoTen, tuoi, diaChi, diemTB);
                    danhSachSinhVien.add(sinhVien);
                } catch (NumberFormatException e) {
                    System.err.println("Dòng không đúng định dạng: " + dong);
                }
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc từ tệp: " + e.getMessage());
        }
    }

    private static void luuFileVaThoat() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
            for (SinhVien sinhVien : danhSachSinhVien) {
                writer.write(sinhVien.getMaSV() + " " + sinhVien.getHoTen() + " " + sinhVien.getDiaChi() + " " + sinhVien.getTuoi() + " " + sinhVien.getDiemTB() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }
    }

    private static void themSinhVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sinh viên mới:");
        System.out.print("Mã sinh viên: ");
        String maSV = scanner.nextLine();
        System.out.print("Họ và tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Tuổi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("Địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.print("Điểm trung bình: ");
        double diemTB = Float.parseFloat(scanner.nextLine());
        SinhVien sinhVienMoi = new SinhVien(maSV, hoTen, tuoi, diaChi, diemTB);
        danhSachSinhVien.add(sinhVienMoi);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            writer.write(maSV + " " + hoTen + " " + tuoi + " " + diaChi + " " + diemTB + "\n");
            System.out.println("Sinh viên đã được thêm vào danh sách.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }
    }

    private static void suaSinhVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String maSV = scanner.nextLine();
        for (SinhVien sinhVien : danhSachSinhVien) {
            if (sinhVien.getMaSV().equals(maSV)) {
                System.out.println("Nhập thông tin mới:");
                System.out.print("Họ và tên: ");
                sinhVien.setHoTen(scanner.nextLine());
                System.out.print("Địa chỉ: ");
                sinhVien.setDiaChi(scanner.nextLine());
                System.out.print("Tuổi: ");
                sinhVien.setTuoi(Integer.parseInt(scanner.nextLine()));
                System.out.print("Điểm trung bình: ");
                sinhVien.setDiemTB(Float.parseFloat(scanner.nextLine()));
                System.out.println("Thông tin sinh viên đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có mã " + maSV);
    }

    private static void xoaSinhVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String maSV = scanner.nextLine();
        danhSachSinhVien.removeIf(sinhVien -> sinhVien.getMaSV().equals(maSV));
        System.out.println("Sinh viên có mã " + maSV + " đã được xóa khỏi danh sách.");
    }

    private static void sapXepTheoHoTen() {
        Collections.sort(danhSachSinhVien, Comparator.comparing(SinhVien::getHoTen));
        System.out.println("Danh sách sinh viên đã được sắp xếp theo họ tên.");
    }

    private static void sapXepTheoDiemTB() {
        Collections.sort(danhSachSinhVien, Comparator.comparing(SinhVien::getDiemTB));
        System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình.");
    }

    private static void hienThiThongTinTatCaSinhVien() {
        System.out.println("Thông tin tất cả sinh viên:");
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Không có dữ liệu");
            return;
        }
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-5s | %-20s | %-10s |\n", "Mã SV", "Họ và tên", "Tuổi", "Địa chỉ", "Điểm TB");
        System.out.println("-----------------------------------------------------------------------------------");
        for (SinhVien sinhVien : danhSachSinhVien) {
            System.out.printf("| %-10s | %-20s | %-5s | %-20s | %-10s |\n", sinhVien.getMaSV(), sinhVien.getHoTen(), sinhVien.getTuoi(), sinhVien.getDiaChi(), sinhVien.getDiemTB());
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
