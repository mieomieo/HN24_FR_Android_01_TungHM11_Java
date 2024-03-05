package assignments;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type n");
        int n = sc.nextInt();
        int factorial  = 1;
        for( int i = 1 ; i <= n;i++){
            factorial  *= i;
        }
        System.out.println(n + "! = " + factorial );
    }
}
