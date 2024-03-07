package oop.exercise4;

public class Nguoi {
    private String hoTen;
    private int tuoi;
    private String ngheNghiep;
    private int soCMND;
    public Nguoi(String hoTen, int tuoi, String ngheNghiep, int soCMND) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.ngheNghiep = ngheNghiep;
        this.soCMND = soCMND;
    }
    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public int getSoCMND() {
        return soCMND;
    }
}
