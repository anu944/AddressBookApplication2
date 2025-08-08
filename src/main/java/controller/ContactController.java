package controller;

import java.util.ArrayList;

import model.Contact;
import view.ContactView;

public class ContactController {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ContactView view = new ContactView();

    public void start() {
        boolean running = true;

        while (running) {
            view.showMenu();
            String choice = view.getInput("Choose an option: ");

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    updateContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    searchContact();
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    view.showMessage("Invalid option.");
            }
        }
    }

    private void addContact() {
        String name = view.getInput("Enter name: ");
        String phone = view.getInput("Enter phone: ");
        String email = view.getInput("Enter email: ");
        contacts.add(new Contact(name, phone, email));
        view.showMessage("Contact added successfully.");
    }

    private void viewContacts() {
        for (Contact contact : contacts) {
            view.showMessage(contact.toString());
        }
    }

    private void updateContact() {
        String name = view.getInput("Enter name to update: ");
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                String newPhone = view.getInput("Enter new phone: ");
                String newEmail = view.getInput("Enter new email: ");
                c.setPhone(newPhone);
                c.setEmail(newEmail);
                view.showMessage("Contact updated.");
                return;
            }
        }
        view.showMessage("Contact not found.");
    }

    private void deleteContact() {
        String name = view.getInput("Enter name to delete: ");
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        view.showMessage("Contact deleted if existed.");
    }

    private void searchContact() {
        String keyword = view.getInput("Enter name to search: ");
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase())) {
                view.showMessage(c.toString());
            }
        }
    }
}