package com.lld.designPattern.parkinglot.entity;

import com.lld.designPattern.parkinglot.building.ParkingLevel;

public class Ticket {

    public String ticketId;
    public Vehicle vehicle;
    public ParkingLevel parkingLevel;
    public ParkingSpot parkingSpot;

    public Ticket(String ticketId, Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        this.parkingSpot = parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
