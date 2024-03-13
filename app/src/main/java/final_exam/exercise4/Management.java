package final_exam.exercise4;
import java.util.ArrayList;

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

    public void addContact(String name, String phoneNumber) {
        if (isPhoneNumberExists(phoneNumber)) {
            System.out.println("Contact already exists.");
        } else {
            contactList.add(new Contact(name, phoneNumber));
            System.out.println("Contact added successfully.");
        }
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
            System.out.println("Unable to update contact. Make sure old number exists and new number does not exist.");
        }
    }

    public void searchContact(String name) {
        System.out.println("Search results for \"" + name + "\":");
        for (Contact contact : contactList) {
            if (contact.getName().contains(name)) {
                System.out.println("Name: " + contact.getName() + ", Phone Number: " + contact.getPhoneNumber());
            }
        }
    }

    public void sortContacts() {
        contactList.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
    }

}
