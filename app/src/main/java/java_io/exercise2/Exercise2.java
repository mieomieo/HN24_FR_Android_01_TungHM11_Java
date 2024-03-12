package java_io.exercise2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import collection.exercise3.Validator;
import java_io.Constant;

public class Exercise2 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        String id, phoneNumber, name;
        System.out.print("Nhập mã khách hàng: ");
        id = sc.nextLine().trim();
        System.out.print("Nhập họ và tên: ");
        name = sc.nextLine().replaceAll("\\s+", "").trim();

        do {
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (!Validator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Số điện thoại không hợp lệ. Số điện thoại phải có 10 hoặc 11 chữ số. Vui lòng thử lại.");
            }
        } while (!Validator.isValidPhoneNumber(phoneNumber));
        System.out.print("Nhập số điện thoại: ");

        try {
            fout = new FileOutputStream(Constant.PROJECT_PATH + "\\exercise2\\khachhang.txt");
            bout = new BufferedOutputStream(fout);
            String s = id + " " + name + " " + phoneNumber;
            byte b[] = s.getBytes();
            bout.write(b);
            bout.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            bout.close();
            fout.close();
        }
        System.out.println("success!");
    }

}
