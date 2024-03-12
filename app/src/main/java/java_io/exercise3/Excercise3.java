package java_io.exercise3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import java_io.Constant;

public class Excercise3 {
    public static void main(String[] args) {
        System.out.println("Nhập mã sinh viên cần tìm điểm trung bình:");
        Scanner sc = new Scanner(System.in);
        String maSV = sc.nextLine().trim().toLowerCase();
        ;
        String filename = Constant.PROJECT_PATH + "exercise3\\sinhvien.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                words[0] = words[0].toLowerCase();
                if (words[0].equals(maSV)) {
                    found = true;
                    System.out.println("Điểm trung bình của sinh viên " + words[1] + ": " + words[2]);
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy sinh viên");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
