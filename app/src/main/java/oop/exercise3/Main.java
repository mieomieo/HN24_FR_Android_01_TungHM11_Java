package oop.exercise3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Nhập doanh thu tháng trước: ");

        System.out.print("Nhập doanh thu tháng trước: ");
        double[] prevMonthRevenue = new double[3];
        for (int i = 0; i < prevMonthRevenue.length; i++) {
            prevMonthRevenue[i] = sc.nextDouble();
        }
//        prevMonthRevenue[0]=300000;   DeluxeRoom
//        prevMonthRevenue[1]=7000000;  PremiumRoom
//        prevMonthRevenue[2]=5000000;  BussinessRoom
        Room[] rooms = {
                new DeluxeRoom(10,50000),
                new PremiumRoom(15,60000),
                new BussinessRoom(20)
        };
        double totalRevenue = 0;
        for(Room room:rooms){
            double revenue = room.calcRevenue();
            totalRevenue += revenue;
            System.out.println("Doanh thu phòng " + room.getType() + ": " + revenue);
        }
        System.out.println("\nTổng doanh thu các phòng:"+totalRevenue);
        System.out.println("\nCác phòng có doanh thu vượt trội:");
        for (int i = 0; i < rooms.length; i++) {
            double revenue = rooms[i].calcRevenue();
            if (revenue >= prevMonthRevenue[i] * 1.25) {
                System.out.println("Phòng " + rooms[i].getType() + " có doanh thu vượt trội.");
            }
        }
    }
}
