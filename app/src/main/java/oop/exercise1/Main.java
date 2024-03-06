package oop.exercise1;

public class Main {
    public static void main(String[] args) {
        Employee officeStaff = new OfficeStaff("Lung Thi Linh","01/01/2000", 22);
        Employee productionStaff = new ProductionStaff("Dinh Van Luc","02/03/1999",500,8000000);
        officeStaff.calcSalary();
        productionStaff.calcSalary();
        officeStaff.show();
        productionStaff.show();
    }
}
