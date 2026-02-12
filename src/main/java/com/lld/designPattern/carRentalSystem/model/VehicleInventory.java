package com.lld.designPattern.carRentalSystem.model;

import com.lld.designPattern.carRentalSystem.enums.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleInventory {

    private static VehicleInventory instance;

    HashMap<Integer, Vehicle> vehicles=new HashMap<>();

    public static synchronized VehicleInventory getInstance() {
        if (instance == null) {
            instance = new VehicleInventory();
        }
        return instance;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.vehicleId,vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle.vehicleId);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Map.Entry<Integer,Vehicle> e: vehicles.entrySet()){
            if(e.getValue().status == Status.AVAILABLE){
                availableVehicles.add(e.getValue());
            }
        }
        return availableVehicles;
    }

    public void setBookedStatus(int vehicleId){
        Vehicle vehicle=vehicles.get(vehicleId);
        vehicle.setStatus(Status.BOOKED);
        vehicles.put(vehicleId,vehicle);
    }
}
