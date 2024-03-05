package assignments;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<0){
            System.out.println("Please type a integer number better than 0");
        }
        int sum = 0;
        for(int i = 0 ; i <=n;i++){
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
