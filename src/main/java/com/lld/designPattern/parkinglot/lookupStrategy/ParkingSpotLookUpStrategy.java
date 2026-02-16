package com.lld.designPattern.parkinglot.lookupStrategy;

import com.lld.designPattern.parkinglot.entity.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookUpStrategy {

    ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);
}
