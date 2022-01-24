import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone myMobile = new MobilePhone("00 25 65 89 87");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();

        while(!quit){
            System.out.println("Enter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    myMobile.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    if(myMobile.getMyContacts().isEmpty()){
                        System.out.println("No contact to update: your contact list is empty");
                    }else {
                        updateContact();
                    }
                    break;

                case 4:
                    if(myMobile.getMyContacts().isEmpty()){
                        System.out.println("No contact to remove: your contact list is empty");
                    }else {
                        removeContact();
                    }

                    break;

                case 5:
                    if(myMobile.getMyContacts().isEmpty()){
                        System.out.println("No contact to query: your contact list is empty");
                    }else {
                        queryContact();
                    }
                    break;

                case 6:
                    printActions();
                    break;

            }
        }

    }
    private static void startPhone(){
        System.out.println("Starting my phone....");
    }
    private static void printActions(){
        System.out.println("Available actions : ");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action : ");
    }
    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(myMobile.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = myMobile.queryContact(name);
        if(existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(myMobile.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated contact");
        } else {
            System.out.println("Error updating contact.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = myMobile.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(myMobile.removeContact(existingContact)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = myMobile.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + " phone number is " + existingContact.getPhoneNumber());
    }

    }
