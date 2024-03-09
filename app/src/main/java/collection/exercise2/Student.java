package collection.exercise2;

public  class Student{
    protected int rollNo;
    protected String name;
    protected String sex;
    protected int age;
    protected String email;
    protected String address;
    public Student(int rollNo,String name, String sex, int age,String email, String address){
        this.rollNo=rollNo;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.email=email;
        this.address=address;
    }
    protected void show() {
        System.out.println("+-------+-------------------+------+------+--------------------------+---------------------------------+");
        System.out.printf("| %-6d| %-17s| %-5s| %-4d | %-24s| %-31s|\n", rollNo, name, sex , age, email, address);
    }

}