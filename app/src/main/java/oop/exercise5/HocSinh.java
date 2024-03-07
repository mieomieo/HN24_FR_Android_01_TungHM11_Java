package oop.exercise5;

import java.util.Scanner;

public class HocSinh {
    private String hoTen,queQuan;
    private int tuoi;

    public HocSinh(){
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap que quan: ");
        queQuan= sc.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = sc.nextInt();
        System.out.println("");
    }

    public void display(){
        System.out.println("Ho ten: "+hoTen);
        System.out.println("Que quan: "+queQuan);
        System.out.println("Tuoi: "+tuoi);
        System.out.println("");
    }

    public int getAge() {
        return tuoi;
    }


    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

}
