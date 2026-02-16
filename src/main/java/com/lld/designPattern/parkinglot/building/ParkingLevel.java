package com.lld.designPattern.parkinglot.building;

import com.lld.designPattern.parkinglot.entity.ParkingSpot;
import com.lld.designPattern.parkinglot.entity.Vehicle;
import com.lld.designPattern.parkinglot.entity.VehicleType;
import com.lld.designPattern.parkinglot.manager.ParkingSpotManager;

import java.util.Map;

public class ParkingLevel {

    public int levelNumber;
    public Map<VehicleType, ParkingSpotManager> typeToParkingSpotManager;

    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> typeToParkingSpotManager){
        this.levelNumber=levelNumber;
        this.typeToParkingSpotManager=typeToParkingSpotManager;
    }


    public boolean hasAvailability(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=typeToParkingSpotManager.get(vehicleType);
        if(parkingSpotManager==null){
            return false;
        }
        return parkingSpotManager.hasSpaceAvailable();
    }

    public ParkingSpot park(Vehicle vehicle){
       ParkingSpotManager parkingSpotManager = typeToParkingSpotManager.get(vehicle.vehicleType);
       return parkingSpotManager.getParkingSpot();
    }
    public void unpark(Vehicle vehicle,ParkingSpot parkingSpot){
        ParkingSpotManager parkingSpotManager=typeToParkingSpotManager.get(vehicle.vehicleType);
        parkingSpotManager.releaseParkingSpot(parkingSpot);
    }
}
