package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        try {
            input(arr);
        }
        catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập không phải là số nguyên.");
        }
        finally {
            for(int i = 0; i < arr.length;i++){
                System.out.printf("arr[%d]= %d\n", i,arr[i]);
            }
        }
    }
    public static void input(int arr[]){
        Scanner sc = new Scanner(System.in);
      for(int i = 0 ; i < arr.length;i++){
          System.out.print("Phan tu "+(i+1)+": ");
          arr[i]= sc.nextInt();
          if(arr[i] == 100){
              throw new ArithmeticException("Bắt đc exception là 100");
          }
      }
    }
}
