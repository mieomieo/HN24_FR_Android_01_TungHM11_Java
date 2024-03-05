package assignments;

import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type n");
        int n;
        do{
            System.out.println("Enter a positive integer");
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not n is greater than or equal to 0. Please re-enter: ", input);
            }
            n = sc.nextInt();
        }while(n<0);
        if (isLeapYear(n)) {
            System.out.println(n + " is a leap year.");
        } else {
            System.out.println(n + " is not a leap year.");
        }
    }
    public static boolean isLeapYear(int n){
        return n % 4 == 0 && (n % 100 != 0 || n % 400 != 0);
    }
}
