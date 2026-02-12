package com.lld.designPattern.bookmyshow.model;

public class Location {

    public int id;
    public String city;
    public String address;

    public Location(int id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
