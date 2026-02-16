package com.lld.designPattern.parkinglot;

import com.lld.designPattern.parkinglot.building.ParkingBuilding;
import com.lld.designPattern.parkinglot.entity.Payment;
import com.lld.designPattern.parkinglot.entity.Ticket;
import com.lld.designPattern.parkinglot.entity.Vehicle;
import com.lld.designPattern.parkinglot.gate.Entrance;
import com.lld.designPattern.parkinglot.gate.Exit;

public class ParkingSystem {
    public ParkingBuilding parkingBuilding;
    public Entrance entrance;
    public Exit exit;

    public ParkingSystem(ParkingBuilding parkingBuilding, Entrance entrance, Exit exit){
        this.parkingBuilding = parkingBuilding;
        this.entrance = entrance;
        this.exit = exit;
    }

    public Ticket vehicleArrives(Vehicle vehicle){
        return entrance.assignTicket(parkingBuilding,vehicle);
    }

    public void vehicleExit(Ticket ticket, Payment payment){
        exit.exitCompletion(parkingBuilding,ticket,payment);
    }
}
