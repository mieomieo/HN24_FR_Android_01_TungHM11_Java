package oop.exercise1;

public class ProductionStaff extends Employee{
    private int numberOfProduct;
    private double defaultSalary;
    public ProductionStaff(String name,String dob, int numberOfProduct,double defaultSalary){
        super(name,dob);
        this.numberOfProduct = numberOfProduct;
        this.defaultSalary = defaultSalary;
    }
    @Override
    public void calcSalary() {
        salary = defaultSalary + numberOfProduct*5000;
    }


}