package com.lld.designPattern.parkinglot.gate;

import com.lld.designPattern.parkinglot.building.ParkingBuilding;
import com.lld.designPattern.parkinglot.entity.Ticket;
import com.lld.designPattern.parkinglot.entity.Vehicle;

public class Entrance {

    public Ticket assignTicket(ParkingBuilding parkingBuilding,Vehicle vehicle){
        return parkingBuilding.allocateTicket(vehicle);
    }
}
