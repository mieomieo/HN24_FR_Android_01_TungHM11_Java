package assignments;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        if(month < 0 || month > 12 ){
            System.out.println("Please type better than 0 and less than 12");
        }
        else if( month >= 1 && month <=3){
            System.out.println("The 1st quarter");
        }
        else if( month >= 4 && month <=6){
            System.out.println("The 2nd quarter");
        }
        else if( month >= 7 && month <=9){
            System.out.println("The 3rd quarter");
        }
        else{
            System.out.println("The 4th quarter");
        }
    }
}
