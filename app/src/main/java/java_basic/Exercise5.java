package java_basic;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type n");
        int n;
        do{
            System.out.println("Enter a positive integer");
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not a positive integer. Please re-enter: ", input);
            }
            n = sc.nextInt();
        }while(n<0);
        int factorial  = 1;
        for( int i = 1 ; i <= n;i++){
            factorial  *= i;
        }
        System.out.println(n + "! = " + factorial );
    }
}
