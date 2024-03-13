package final_exam.exercise4;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Management {
    private ArrayList<Contact> contactList;

    public Management() {
        contactList = new ArrayList<>();
    }

    public boolean isPhoneNumberExists(String phoneNumber) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }


    public void addContact(Scanner sc, Management contactManagement) {
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
        boolean phoneNumberCheck;
        do {
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (!Validator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. Phone number must be 10 or 11 digits. Please try again.");
                phoneNumberCheck = false;
            } else if (contactManagement.isPhoneNumberExists(phoneNumber)) {
                System.out.println("Phone number exists. Try another number phone");
                phoneNumberCheck = false;
            } else {
                phoneNumberCheck = true;
            }
        } while (!phoneNumberCheck);
        contactList.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    public void editContact(String oldPhoneNumber, String newPhoneNumber) {
        boolean oldExists = false;
        boolean newExists = false;

        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(oldPhoneNumber)) {
                oldExists = true;
            }
            if (contact.getPhoneNumber().equals(newPhoneNumber)) {
                newExists = true;
            }
        }

        if (oldExists && !newExists) {
            for (Contact contact : contactList) {
                if (contact.getPhoneNumber().equals(oldPhoneNumber)) {
                    contact.setPhoneNumber(newPhoneNumber);
                    System.out.println("Contact updated successfully.");
                    return;
                }
            }
        } else {
            System.out.println("Make sure old number exists and new number does not exist. Try again!");
        }
    }


    public void sortContacts() {
        contactList.sort(Comparator.comparing(Contact::getName));
    }

    public void searchContact(String name) {

        boolean checkSearch = false;
        System.out.println("Search results for \"" + name + "\":");
        System.out.println("+-----------------+-----------------+");
        System.out.println("|      Name       |  Phone Number   |");
        System.out.println("+-----------------+-----------------+");
        for (Contact contact : contactList) {
            String nameFormat = removeDiacritics(contact.getName().toLowerCase());
            if (nameFormat.contains(removeDiacritics(name.toLowerCase()))) {
                System.out.printf("| %-15s | %-15s |\n", contact.getName(), contact.getPhoneNumber());
                checkSearch = true;
            }
        }
        if (!checkSearch) {
            System.out.println("|           NO DATA MATCH           |");
            System.out.println("+-----------------+-----------------+");
        }
    }

    public void display() {
        if (contactList.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Contact list:");
            System.out.println("+----+-----------------+-----------------+");
            System.out.println("| ID |      Name       |  Phone Number   |");
            System.out.println("+----+-----------------+-----------------+");
            for (int i = 0; i < contactList.size(); i++) {
                Contact contact = contactList.get(i);
                System.out.printf("| %-2d | %-15s | %-15s |\n", i + 1, contact.getName(), contact.getPhoneNumber());
                System.out.println("+----+-----------------+-----------------+");
            }
        }
    }

    private String removeDiacritics(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
