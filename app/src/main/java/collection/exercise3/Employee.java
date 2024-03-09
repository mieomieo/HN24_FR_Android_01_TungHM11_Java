package collection.exercise3;

import java.util.regex.Pattern;


public  class Employee {
    private static int nextId = 1;
    private int id;
    private String name;
    private String gender;
    private String dob;
    private String phoneNumber;
    private String educationLevel;

    public Employee(String name, String gender, String dob, String phoneNumber, String educationLevel) {
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.educationLevel = educationLevel;
    }

    public void displayInfo() {
        System.out.println("+-------+-------------------+------+------+--------------------------+---------------------------------+");
        System.out.printf("| %-6d| %-17s| %-5s| %-4d | %-24s| %-31s|\n", id, name, gender , dob, phoneNumber, educationLevel);

    }

    public void updateInfo(String name, String gender, String dob, String phoneNumber, String educationLevel) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.educationLevel = educationLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}