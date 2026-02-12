package com.lld.designPattern.carRentalSystem.model;

import com.lld.designPattern.carRentalSystem.enums.ReservationStatus;

public class Reservation {
    int id;
    Vehicle vehicle;
    String bookedfrom;
    String bookedto;
    ReservationStatus status;
    Location location;

    public Reservation(){

    }

    public Reservation(int id, Vehicle vehicle, String bookedfrom, String bookedto, ReservationStatus status, Location location) {
        this.id = id;
        this.vehicle = vehicle;
        this.bookedfrom = bookedfrom;
        this.bookedto = bookedto;
        this.status = status;
        this.location = location;
    }
}
