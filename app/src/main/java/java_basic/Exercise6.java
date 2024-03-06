package java_basic;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        do{
            System.out.println("Enter a positive integer");
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not a positive integer. Please re-enter: ", input);
            }
            n = sc.nextInt();
        }while(n<0);
        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            sum +=i;
        }
        System.out.println("result= "+ sum);
        sc.close();
    }
}
