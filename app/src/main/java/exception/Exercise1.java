package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a,b;
        try{
            System.out.println("Nhập số bị chia:");
            a = sc.nextDouble();
            System.out.println("Nhập số chia:");
            b = sc.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập không phải là số.");
            return; // Kết thúc chương trình khi nhập không phải là số
        }
        try {
            division(a, b);
        } catch (ArithmeticException e) {
            System.out.println("Phép chia không hợp lệ: " + e.getMessage());
        }

        sc.close();

    }
    public static void division(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Số chia không thể là 0.");
        }

        double result = a / b;
        System.out.println("Kết quả của phép chia: " + result);
    }
}
