package oop.exercise5;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Lop lop = new Lop();
        System.out.print("Nhap so lop: ");
        int numClass = sc.nextInt();
        for (int i = 0; i<numClass;i++){
            System.out.print("Nhap lop: ");
            String className = sc.next();
            lop.setLop(className);
            lop.input();
        }
    }
}
