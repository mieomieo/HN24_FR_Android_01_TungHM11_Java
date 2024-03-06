package oop.exercise1;

public class OfficeStaff extends Employee{
    private int numberDayOfWork;
    public OfficeStaff(String name,String dob, int numberDayOfWork){
        super(name,dob);
        this.numberDayOfWork = numberDayOfWork;
    }
    @Override
    public void calcSalary() {
        salary = numberDayOfWork*100000;
    }


}
