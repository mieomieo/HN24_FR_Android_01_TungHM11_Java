package collection.exercise2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //Tạo 1 lớp sinh viên gồm các thuộc tính (RollNo, Name, Sex, Age, Email,
        //Address). Tạo một HashMap quản lý danh sách sinh viên, dùng rollNo là
        //key cho HashMap. Xây dựng menu chương trình:
        //1, Nhập N sinh viên.
        // 2, In thông tin sinh viên.
        // 3, Tìm kiếm sinh viên (Yêu
        //cầu nhập RollNo và hiển thị thông tin sinh viên đó)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, Student> students = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin của sinh viên thứ " + (i + 1) + ":");
            System.out.println("Nhập mã sinh viên: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // Clear buffer
            System.out.println("Nhập tên sinh viên: ");
            String name = sc.nextLine();
            System.out.println("Nhập giới tính (Nam/Nữ): ");
            boolean sex = sc.nextLine().equalsIgnoreCase("Nam");
            System.out.println("Nhập tuổi: ");
            int age = sc.nextInt();
            sc.nextLine(); // Clear buffer
            System.out.println("Nhập email: ");
            String email = sc.nextLine();
            System.out.println("Nhập địa chỉ: ");
            String address = sc.nextLine();
            students.put(rollNo, new Student(rollNo, name, sex, age, email, address));
        }
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Student> entry = iterator.next();
//            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
//        }


    }
}
