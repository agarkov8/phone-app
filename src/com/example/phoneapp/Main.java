package com.example.phoneapp;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<Contacts> contacts;
    private static Scanner scanner;
    private static int id = 0;

    private static void manageContacts(){
        System.out.println("Please select one:" +
                "\n\t1.Show all contacts" +
                "\n\t2.Add new contact" +
                "\n\t3.Search for a new contact" +
                "\n\t4.Delete a contact" +
                "\n\t5.Go back to the previous menu");

        int choice = scanner.nextInt();
        switch (choice){
            case 1: showAllContacts();break;
            case 2: addNewContact();break;
            case 3: searchForContact();break;
            case 4: deleteContact();break;
            default: showInitialOptions(); break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the name:");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the contact's name again:");
            deleteContact();
        } else{
            boolean doesExist = false;
            for (Contacts c: contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);

                }
            }
            if (!doesExist){
                System.out.println("There is no such contact!");
            }
        }

        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enter the name of the contact");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the name again:");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contacts c: contacts) {
                if (c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }
            }

            if (!doesExist){
                System.out.println("There is no such contact! ");
            }

        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact...");
        System.out.println("Please enter the contact's name");
        String name = scanner.next();
        System.out.println("Please enter the contact's number");
        String number = scanner.next();
        System.out.println("Please enter the contact's email");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please enter all of the information:");
            addNewContact();
        } else {
            boolean doesExist = false;

            for (Contacts c: contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                }
            }

            if (doesExist){
                System.out.println("We have a contact" + name + " saved on this device!");
                addNewContact();
            } else {
                Contacts contact = new Contacts(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }
        }

        showInitialOptions();
    }

    private static void showAllContacts() {
        for (Contacts c: contacts) {
            c.getDetails();
            System.out.println("********");
        }
        showInitialOptions();
    }

    private static void showInitialOptions(){
        System.out.println("Please select one:" +
                "\n\t1.Manage contacts" +
                "\n\t2.Messages" +
                "\n\t3.Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1: manageContacts(); break;
            case 2: manageMessages(); break;
            default: break;
        }

    }

    private static void manageMessages() {
        System.out.println("Please select one:" +
                "\n\t1.Show all messages" +
                "\n\t2.Send a new message" +
                "\n\t3.Go back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1: showAllMessages();break;
            case 2: sendNewMessage();break;
            default: showInitialOptions();break;

        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send a message?");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the name of the contact");
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (Contacts c: contacts) {
                if (c.getName().equals(name)){
                    doesExist = true;
                }

            }

            if (!doesExist){
                System.out.println("What are you going to say?");
                String text = scanner.next();
                if (text.equals("")){
                    System.out.println("Please enter some message");
                    sendNewMessage();
                } else {
                    id++;
                    Messages newMessage = new Messages(text, name, id);
                    for (Contacts c: contacts){
                        if (c.getName().equals(name)){
                            ArrayList<Messages> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            Contacts currectContract = c;
                            currectContract.setMessages(newMessages);
                            contacts.remove(c);
                            contacts.add(currectContract);
                        }
                    }
                }

            } else {
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Messages> allMessages = new ArrayList<>();
        for (Contacts c:contacts) {
            allMessages.addAll(c.getMessages());
        }

        if (allMessages.size() > 0){
            for (Messages m: allMessages){
                m.getDetails();
                System.out.println("*********");
            }
        } else {
            System.out.println("You don't have any message");
        }

        showInitialOptions();
    }

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome!");
        showInitialOptions();

    }
}
