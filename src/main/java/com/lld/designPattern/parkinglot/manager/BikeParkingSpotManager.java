package com.lld.designPattern.parkinglot.manager;

import com.lld.designPattern.parkinglot.entity.ParkingSpot;
import com.lld.designPattern.parkinglot.lookupStrategy.ParkingSpotLookUpStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class BikeParkingSpotManager implements ParkingSpotManager{

    public List<ParkingSpot> twoWheelerParkingSpots;
    public ParkingSpotLookUpStrategy strategy;
    private final ReentrantLock lock = new ReentrantLock(true);

    public BikeParkingSpotManager(List<ParkingSpot>  twoWheelerParkingSpots, ParkingSpotLookUpStrategy strategy) {
        this.twoWheelerParkingSpots = twoWheelerParkingSpots;
        this.strategy = strategy;
    }

    @Override
    public boolean hasSpaceAvailable() {
        lock.lock();
        try {
           for(int i=0;i<twoWheelerParkingSpots.size();i++){
            if(twoWheelerParkingSpots.get(i).isFree()){
                return true;
            }
           }
           return false;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public ParkingSpot getParkingSpot() {
        lock.lock();
        try {
            ParkingSpot parkingSpot= strategy.selectSpot(twoWheelerParkingSpots);
            parkingSpot.setFree(false);
            return parkingSpot;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void releaseParkingSpot(ParkingSpot parkingSpot) {
       lock.lock();
       try {
          parkingSpot.setFree(true);
       }finally {
           lock.unlock();
       }
    }
}
