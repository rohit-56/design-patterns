package com.lld.designPattern.parkinglot.manager;

import com.lld.designPattern.parkinglot.entity.ParkingSpot;
import com.lld.designPattern.parkinglot.entity.Vehicle;

public interface ParkingSpotManager {

    public boolean hasSpaceAvailable();

    public ParkingSpot getParkingSpot();

    public void releaseParkingSpot(ParkingSpot parkingSpot);
}
