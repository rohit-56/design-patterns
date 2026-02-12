package com.lld.designPattern.carRentalSystem.model;

public class Location {

    public int id;
    public String city;
    public String address;
    public int pincode;

    public Location(int id, String city, String address, int pincode) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.pincode = pincode;
    }
}
