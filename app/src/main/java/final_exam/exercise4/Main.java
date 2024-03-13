package final_exam.exercise4;

import java.util.Scanner;

import collection.exercise3.Validator;

public class Main {
    public static void main(String[] args) {
        Management contactManagement = new Management();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Check if a phone number exists");
            System.out.println("2. Add a contact");
            System.out.println("3. Edit a contact");
            System.out.println("4. Search for a contact");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "0":
                    System.out.println("Exiting program.");
                    return;
                case "1":
                    System.out.print("Enter phone number to check: ");
                    String phoneNumberToCheck = sc.nextLine();
                    boolean exists = contactManagement.isPhoneNumberExists(phoneNumberToCheck);
                    if (exists) {
                        System.out.println("Phone number exists.");
                    } else {
                        System.out.println("Phone number does not exist.");
                    }
                    break;
                case "2":
                    System.out.print("Enter name: ");
                    String name;
                    do {
                        System.out.print("Name: ");
                        name = sc.nextLine().trim();
                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty. Please try again.");
                        }
                    } while (name.isEmpty());

                    System.out.print("Enter phone number: ");
                    String phoneNumber;
                    do {
                        System.out.print("Phone Number: ");
                        phoneNumber = sc.nextLine().trim();
                        if (!Validator.isValidPhoneNumber(phoneNumber)) {
                            System.out.println("Invalid phone number. Phone number must be 10 or 11 digits. Please try again.");
                        }
                    } while (!Validator.isValidPhoneNumber(phoneNumber));
                    contactManagement.addContact(name, phoneNumber);
                    break;
                case "3":
                    System.out.print("Enter old phone number: ");
                    String oldPhoneNumber = sc.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = sc.nextLine();
                    contactManagement.editContact(oldPhoneNumber, newPhoneNumber);
                    break;
                case "4":
                    System.out.print("Enter name to search: ");
                    String nameToSearch = sc.nextLine();
                    contactManagement.searchContact(nameToSearch);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }
    }
}
