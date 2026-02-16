package com.lld.designPattern.parkinglot.entity;

public class ParkingSpot {
    public String spotNumber;
    public boolean isFree;
    public ParkingSpot(String spotNumber) {
        this.spotNumber = spotNumber;
        this.isFree = true;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
