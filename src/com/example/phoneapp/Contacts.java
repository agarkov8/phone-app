package com.example.phoneapp;

import java.util.ArrayList;

public class Contacts {

    private String name;
    private String number;
    private String email;
    private ArrayList<Messages> messages;

    public Contacts(String name, String number, String email, ArrayList<Messages> messages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }

    //When a new contact is created, he does not have any messages yet
    public Contacts(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>();
    }

    public void getDetails(){
        System.out.println("Name: " + this.name +
                "" + "\nNumber: " + this.number +
                "" + "\nEmail: " + this.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Messages> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Messages> messages) {
        this.messages = messages;
    }
}
