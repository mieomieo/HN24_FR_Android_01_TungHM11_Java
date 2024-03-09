package collection.exercise2;

public  class Student{
    protected int rollNo;
    protected String name;
    protected boolean sex;  // chỉ 2 giới tính
    protected int age;
    protected String email;
    protected String address;
    public Student(int rollNo,String name, boolean sex, int age,String email, String address){
        this.rollNo=rollNo;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.email=email;
        this.address=address;
    }
    protected void show(){
        System.out.println("rollNo="+rollNo);
        System.out.println("name="+name);
        System.out.println("sex="+sex);
        System.out.println("age="+age);
        System.out.println("email="+email);
        System.out.println("address="+address);
    }
}