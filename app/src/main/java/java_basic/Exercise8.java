package java_basic;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = findGCD(a,b);
        System.out.println("Greatest common divisor="+gcd);
    }
    public  static int findGCD(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
