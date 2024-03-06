package oop.exercise1;

public abstract class Employee {
   protected String name;
   protected String dob;
   protected double salary;
   public Employee(String name, String dob){
       this.name=name;
       this.dob = dob;
   }
   public abstract void calcSalary();
   public void show(){
       System.out.println("Name="+name);
       System.out.println("DOB="+dob);
       System.out.println("Salary="+salary);
   }
}
