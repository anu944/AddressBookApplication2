package view;

import java.util.Scanner;

public class ContactView {
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n--- Address Book Menu ---");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Search Contact");
        System.out.println("6. Exit");
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}