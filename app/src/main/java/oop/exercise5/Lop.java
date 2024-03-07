package oop.exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lop {

    private String lop;

    public void input(){
        Scanner sc = new Scanner(System.in);
        //    HashMap<Integer,HocSinh> listHocsinh = new HashMap<>();
        List<HocSinh> listHocSinh = new ArrayList<>();
        System.out.print("Nhap so hoc sinh trong lop: ");
        int student = sc.nextInt();
        for (int i=0;i<student;i++){
            HocSinh hocSinh = new HocSinh();
            hocSinh.input();
            listHocSinh.add(hocSinh);
        }

        int count=0;
        HocSinh hocSinh = new HocSinh();
        for (HocSinh temp : listHocSinh ){
            if (temp.getAge()==20){
                System.out.println("Thong tin hoc sinh 20 tuoi: ");
                System.out.println("Name: "+temp.getHoTen());
                System.out.println("Hometown: "+temp.getQueQuan());
                System.out.println("");
            }
            if (temp.getAge()==23&& temp.getQueQuan().equalsIgnoreCase("ha noi")){
                count++;
            }
        }
        System.out.println("So hoc sinh 23 tuoi que Ha Noi: "+count);
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
}

