package collection.exercise3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Map<Integer, Employee> employees = new HashMap<>();

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Add employee");
                System.out.println("2. Display employee");
                System.out.println("3. Update employee");
                System.out.println("4. Find employee");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                String choice = sc.nextLine();

                switch (choice) {
                    case "0":
                        System.out.println("Exiting program.");
                        return;
                    case "1":
                        addEmployee(sc, employees);
                        break;
                    case "2":
                        displayEmployees(employees);
                        break;
                    case "3":
                        updateEmployee(sc, employees);
                        break;
                    case "4":
                        findEmployee(sc, employees);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

    private static void addEmployee(Scanner sc, Map<Integer, Employee> employees) {
        System.out.println("Enter employee details:");
        String name ,gender ,dob ,phoneNumber ,educationLevel ;
        do {
            System.out.print("Name: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            }
        } while (name.isEmpty());

        do {
            System.out.print("Gender (Male/Female): ");
            gender = sc.nextLine().trim();
            if (!Validator.isValidGender(gender)) {
                System.out.println("Invalid gender. Gender must be 'Male' or 'Female'. Please try again.");
            }
        } while (!Validator.isValidGender(gender));


        do {
            System.out.print("Date of Birth (dd/mm/yyyy): ");
            dob = sc.nextLine().trim();
            if (!Validator.isValidDateOfBirth(dob)) {
                System.out.println("Invalid date format. Date of Birth must be in dd/mm/yyyy format. Please try again.");
            }
        } while (!Validator.isValidDateOfBirth(dob));


        do {
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (!Validator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. Phone number must be 10 or 11 digits. Please try again.");
            }
        } while (!Validator.isValidPhoneNumber(phoneNumber));


        do {
            System.out.print("Education Level (Intermediate/College/University): ");
            educationLevel = sc.nextLine().trim();
            if (!Validator.isValidEducationLevel(educationLevel)) {
                System.out.println("Invalid education level. Education level must be 'Intermediate', 'College', or 'University'. Please try again.");
            }
        } while (!Validator.isValidEducationLevel(educationLevel));

        Employee employee = new Employee(name, gender, dob, phoneNumber, educationLevel);
        employees.put(employee.getId(), employee);
        System.out.println("Employee added successfully.");
    }
    private static void displayEmployees(Map<Integer, Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Not found information.");
            return;
        }
        System.out.println("Employee information:");
        System.out.println("+-------+------------------+--------+----------------+----------------+----------------------+");
        System.out.printf("| %-6s| %-17s| %-7s| %-15s | %-15s| %-20s|\n", "ID", "Name", "Gender", "Date of Birth", "Phone Number", "Education Level");
        for (Employee employee : employees.values()) {
            employee.displayInfo();
        }
        System.out.println("+-------+------------------+--------+----------------+----------------+----------------------+");
    }

    private static void updateEmployee(Scanner sc, Map<Integer, Employee> employees) {
            System.out.print("Enter employee ID to update: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Employee employee = employees.get(id);
            if (employee == null) {
                System.out.println("Employee not found.");
                return;
            }


        String name ,gender ,dob ,phoneNumber ,educationLevel ;
        do {
            System.out.print("Name: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            }
        } while (name.isEmpty());

        do {
            System.out.print("Gender (Male/Female): ");
            gender = sc.nextLine().trim();
            if (!Validator.isValidGender(gender)) {
                System.out.println("Invalid gender. Gender must be 'Male' or 'Female'. Please try again.");
            }
        } while (!Validator.isValidGender(gender));


        do {
            System.out.print("Date of Birth (dd/mm/yyyy): ");
            dob = sc.nextLine().trim();
            if (!Validator.isValidDateOfBirth(dob)) {
                System.out.println("Invalid date format. Date of Birth must be in dd/mm/yyyy format. Please try again.");
            }
        } while (!Validator.isValidDateOfBirth(dob));


        do {
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (!Validator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. Phone number must be 10 or 11 digits. Please try again.");
            }
        } while (!Validator.isValidPhoneNumber(phoneNumber));


        do {
            System.out.print("Education Level (Intermediate/College/University): ");
            educationLevel = sc.nextLine().trim();
            if (!Validator.isValidEducationLevel(educationLevel)) {
                System.out.println("Invalid education level. Education level must be 'Intermediate', 'College', or 'University'. Please try again.");
            }
        } while (!Validator.isValidEducationLevel(educationLevel));
            employee.updateInfo(name, gender, dob, phoneNumber, educationLevel);
            System.out.println("Employee information updated successfully.");
        }

        private static void findEmployee(Scanner sc, Map<Integer, Employee> employees) {
            System.out.print("Enter employee ID or name to search: ");
            String input = sc.nextLine().trim();
            boolean found = false;
            for (Employee employee : employees.values()) {
                if (String.valueOf(employee.getId()).equals(input) || employee.getName().equalsIgnoreCase(input)) {
                    employee.displayInfo();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Not found information.");
            }
        }
    }


