package java_basic;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double score = sc.nextDouble();
        if(score>10 || score <0){
            System.out.println("Wrong number");
        }
        else if(score >= 5){
            System.out.print("Pass");
        }
        else{
            System.out.print("Failed");
        }
        sc.close();
    }
}
