package com.lld.designPattern.carRentalSystem.model;

import com.lld.designPattern.carRentalSystem.enums.VehicleType;

public class Bike extends Vehicle{

    public Bike(int vehicleId, String company, String color, String model, int hourlyCost, String vehicleNumber, int seats) {
        super(vehicleId, company, color, model, hourlyCost, vehicleNumber, seats);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }
}
