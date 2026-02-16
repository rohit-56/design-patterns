package com.lld.designPattern.parkinglot.entity;

public class Vehicle {
    public String vehicleNumber;
    public VehicleType vehicleType;

    public  Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
