package com.lld.designPattern.carRentalSystem.model;

import com.lld.designPattern.carRentalSystem.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public int storeId;
    public VehicleInventory vehicleInventory;
    public List<Reservation> reservationList;
    public Location location;


    public Store(int storeId,Location location) {
        this.storeId = storeId;
        this.location=location;
        this.vehicleInventory=VehicleInventory.getInstance();
        this.reservationList=new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        this.reservationList.add(reservation);
        //Updating Status of Vehicle
        vehicleInventory.setBookedStatus(reservation.vehicle.vehicleId);
    }


}
