package com.example.steve.contacts;

import android.content.ContentValues;

import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private final String name;
    private final String email;
    private final String address;
    private final String phoneNumber;
    private final String website;
    private final Float rating;


    public Student(String name, String email, String address, String phoneNumber, String website,Float rating){

        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.rating = rating;
    }

    public Student(int id, String name, String email, String address, String phoneNumber, String website, Float rating) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public String getName() {
        return name;
    }

    public Float getRating(){
        return rating;
    }

    @Override
    public String toString() {
        return id + " " +name;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        values.put("email", email);
        values.put("phoneNumber", phoneNumber);
        values.put("website", website);
        values.put("rating",rating);
        return values;
    }
}
