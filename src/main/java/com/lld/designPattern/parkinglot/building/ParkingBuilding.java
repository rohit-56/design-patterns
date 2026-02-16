package com.lld.designPattern.parkinglot.building;

import com.lld.designPattern.parkinglot.entity.ParkingSpot;
import com.lld.designPattern.parkinglot.entity.Ticket;
import com.lld.designPattern.parkinglot.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public class ParkingBuilding {

    public List<ParkingLevel> parkingLevels;

    public ParkingBuilding(List<ParkingLevel> parkingLevels){
        this.parkingLevels=parkingLevels;
    }


    public Ticket allocateTicket(Vehicle vehicle){
        for(ParkingLevel parkingLevel:parkingLevels){
            if(parkingLevel.hasAvailability(vehicle.vehicleType)){
               ParkingSpot parkingSpot =parkingLevel.park(vehicle);
                return new Ticket(""+vehicle.vehicleNumber+":"+ LocalDate.now(),
                        vehicle,parkingLevel,parkingSpot);
            }
        }
        System.out.println("No available parking spot found");
        return null;
    }

    public void releaseSpot(Ticket ticket){
        ticket.getParkingLevel().unpark(ticket.getVehicle(),ticket.getParkingSpot());
    }
}
