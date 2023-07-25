package com.slimripah.isit;

public class UserHelperClass {

    String name, contact;

    //empty constructor
    public UserHelperClass () {

    }

    //constructors
    public UserHelperClass(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
