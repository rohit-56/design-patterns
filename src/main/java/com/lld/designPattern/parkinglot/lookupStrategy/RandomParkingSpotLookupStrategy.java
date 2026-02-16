package com.lld.designPattern.parkinglot.lookupStrategy;

import com.lld.designPattern.parkinglot.entity.ParkingSpot;

import java.util.List;

public class RandomParkingSpotLookupStrategy implements ParkingSpotLookUpStrategy {

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.isFree()) {
                return parkingSpot;
            }
        }
        return null;
    }
}
