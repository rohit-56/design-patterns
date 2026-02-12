package com.lld.designPattern.carRentalSystem.model;

import com.lld.designPattern.carRentalSystem.enums.Status;
import com.lld.designPattern.carRentalSystem.enums.VehicleType;

public abstract class Vehicle {

    public int vehicleId;
    public String company;
    public String color;
    public String model;
    public int hourlyCost;
    public String vehicleNumber;
    public int seats;
    public Status status;

    public Vehicle(int vehicleId, String company, String color, String model, int hourlyCost, String vehicleNumber, int seats) {
        this.vehicleId = vehicleId;
        this.company = company;
        this.color = color;
        this.model = model;
        this.hourlyCost = hourlyCost;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.status = Status.AVAILABLE;
    }

    public abstract VehicleType getVehicleType();

    public void setStatus(Status status) {
        this.status = status;
    }
}
