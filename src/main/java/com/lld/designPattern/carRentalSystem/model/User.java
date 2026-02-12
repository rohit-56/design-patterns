package com.lld.designPattern.carRentalSystem.model;

public class User {

    int userId;
    String name;
    String email;
    String phone;
    String drivingLicense;

    public User(int userId, String name, String email, String phone, String drivingLicense) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.drivingLicense = drivingLicense;
    }
}
