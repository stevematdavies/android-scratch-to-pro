package com.example.steve.contacts;

/**
 * Created by steve on 5.8.2016.
 */
public class Student {


    private final String name;
    private final String email;
    private final String address;
    private final String phoneNumber;
    private final String website;
    private final Float rating;

    Student(String name, String email, String address, String phoneNumber, String website, Float rating){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Float getRating(){
        return rating;
    }
}
