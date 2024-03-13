package final_exam;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n ;
        do {
            System.out.print("Nhập số nguyên dương n: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Vui lòng nhập số nguyên dương.");
            }
        } while (n <= 0);

        int sumOfDigits = sumOfDigits(n);
        System.out.println("a. Tổng các chữ số của n: " + sumOfDigits);

        System.out.print("b. Phân tích " + n + " thành các số nguyên tố: ");
        primeFactors(n);


        System.out.print("c. Các ước của " + n + ": ");
        listDivisors(n);

        System.out.print("d. Các ước nguyên tố của " + n + ": ");
        listPrimeDivisors(n);
    }
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void primeFactors(int n) {
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
                n /= i;
            }
        }
        System.out.println();
    }
    public static void listDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void listPrimeDivisors(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
