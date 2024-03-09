package collection.exercise2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Student> mapStudents = new HashMap<>();
        while(true){
            System.out.println("Menu:");
            System.out.println("1. Nhập thông tin sinh viên.");
            System.out.println("2. In thông tin sinh viên.");
            System.out.println("3. Tìm kiếm sinh viên.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Chọn chức năng (0-3): ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Đóng chương trình");
                    return;
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin của sinh viên thứ " + (i + 1) + ":");
                        System.out.print("Nhập mã sinh viên: ");
                        int rollNo;
                        boolean isRollNoUnique;
                        do {
                            rollNo = sc.nextInt();
                            sc.nextLine(); // Clear buffer
                            isRollNoUnique = !mapStudents.containsKey(rollNo);
                            if (!isRollNoUnique) {
                                System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập lại.");
                            }
                        } while (!isRollNoUnique);

                        String name;
                        do {
                            System.out.print("Nhập tên sinh viên: ");
                            name = sc.nextLine().trim();
                            if (name.isEmpty()) {
                                System.out.println("Tên không được để trống. Vui lòng nhập lại.");
                            }
                        } while (name.isEmpty());


                        String sex;
                        do {
                            System.out.print("Nhập giới tính (Nam/Nữ): ");
                            sex = sc.nextLine().trim();
                            if (!sex.equalsIgnoreCase("Nam") && !sex.equalsIgnoreCase("Nữ")) {
                                System.out.println("Giới tính không hợp lệ. Chỉ được nhập 'Nam' hoặc 'Nữ'.");
                            }
                        } while (!sex.equalsIgnoreCase("Nam") && !sex.equalsIgnoreCase("Nữ"));


                        int age;
                        do {
                            System.out.print("Nhập tuổi: ");
                            while (!sc.hasNextInt()) {
                                System.out.println("Tuổi phải là một số nguyên. Vui lòng nhập lại.");
                                sc.next();
                            }
                            age = sc.nextInt();
                            sc.nextLine();
                            if (age <= 0) {
                                System.out.println("Tuổi phải là một số nguyên dương. Vui lòng nhập lại.");
                            }
                        } while (age <= 0);
                        String email;
                        do {
                            System.out.print("Nhập email: ");
                            email = sc.nextLine().trim();
                            if (!isValidEmail(email)) {
                                System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
                            }
                        } while (!isValidEmail(email));
                        String address;
                        do {
                            System.out.print("Nhập địa chỉ: ");
                            address = sc.nextLine().trim();
                            if (address.isEmpty()) {
                                System.out.println("Địa chỉ không được để trống. Vui lòng nhập lại.");
                            }
                        } while (address.isEmpty());
                        mapStudents.put(rollNo, new Student(rollNo, name, sex, age, email, address));
                    }
                    break;
                case 2:
                    if(mapStudents.isEmpty()){
                        System.out.println("Danh sách sinh viên rỗng yêu cầu ấn phím 1: ");
                        break;
                    }
                    else {
                        System.out.println("Danh sách các sinh viên: ");
                        System.out.println("+-------+-------------------+------+------+--------------------------+---------------------------------+");
                        System.out.printf("| %-6s| %-17s| %-5s| %-4s | %-24s| %-31s|\n", "RollNo", "Name", "Sex", "Age", "Email", "Address");
                        for(Student student:mapStudents.values() ){
                            student.show();
                        }
                        System.out.println("+-------+-------------------+------+------+--------------------------+---------------------------------+");
                        break;
                    }

                case 3:
                    System.out.print("Nhập mã sinh viên cần tìm: ");
                    int searchRollNo = sc.nextInt();
                    Student searchedStudent = mapStudents.get(searchRollNo);
                    if (searchedStudent != null) {
                        searchedStudent.show();
                        System.out.println("+-------+-------------------+------+------+--------------------------+---------------------------------+");
                    } else {
                        System.out.println("Không tìm thấy sinh viên có mã số " + searchRollNo);
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

    }
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
