package final_java.exercise1;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n;
        do {
            System.out.print("Nhập số nguyên n: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println(input + " không phải là số nguyên. Vui lòng nhập lại.");
                System.out.print("Nhập số nguyên n: ");
            }
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Số nguyên n phải lớn hơn 0. Vui lòng nhập lại.");
            }
        } while (n <= 0);
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.println(input + " không phải là số nguyên. Vui lòng nhập lại.");
                    System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
                }
                arr[i] = scanner.nextInt();
            } while (arr[i] <= 0);
        }
        Arrays.sort(arr);
        System.out.print("Nhập phần tử cần chèn: ");
        int x=0;
        boolean isValid=false;
        do {
            System.out.print("Nhập phần tử cần chèn: ");
            if (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println(input + " không phải là số nguyên. Vui lòng nhập lại.");
            } else {
                x = scanner.nextInt();
                isValid = true;
            }
        } while (!isValid);

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < x) {
                index++;
            } else {
                break;
            }
        }
        int[] newArr = new int[n + 1];

        for (int i = 0, j = 0; i < n + 1; i++) {
            if (i == index) {
                newArr[i] = x;
            } else {
                newArr[i] = arr[j++];
            }
        }
        System.out.println("Mảng sau khi chèn phần tử mới:");
        System.out.println(Arrays.toString(newArr));

    }
}
