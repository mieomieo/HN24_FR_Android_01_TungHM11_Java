package final_exam;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        for (int i = 10000; i < 1000000; i++) {
            if (prime(i) && palindrome(i) && allPrime(i) && primeSum(i)) {
                result.add(i);
            }
        }
        System.out.print("Result: " + result);
    }

    public static boolean prime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean palindrome(int n) {
        int reversedNum = 0;
        int originalNum = n;
        while (n != 0) {
            int remainder = n % 10;
            reversedNum = reversedNum * 10 + remainder;
            n /= 10;
        }
        return originalNum == reversedNum;
    }

    public static boolean allPrime(int n) {
        while (n != 0) {
            int digit = n % 10;
            if (!prime(digit)) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static boolean primeSum(int n) {
        int digitSum = 0;
        while (n != 0) {
            int digit = n % 10;
            digitSum += digit;
            n /= 10;
        }
        return prime(digitSum);
    }
}