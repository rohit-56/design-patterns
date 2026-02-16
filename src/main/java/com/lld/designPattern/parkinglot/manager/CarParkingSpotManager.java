package com.lld.designPattern.parkinglot.manager;

import com.lld.designPattern.parkinglot.entity.ParkingSpot;
import com.lld.designPattern.parkinglot.lookupStrategy.ParkingSpotLookUpStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class CarParkingSpotManager implements ParkingSpotManager{

    public List<ParkingSpot> fourWheelerParkingSpots;
    public ParkingSpotLookUpStrategy strategy;
    private final ReentrantLock lock = new ReentrantLock(true);

    public CarParkingSpotManager(List<ParkingSpot> fourWheelerParkingSpots, ParkingSpotLookUpStrategy strategy) {
        this.fourWheelerParkingSpots = fourWheelerParkingSpots;
        this.strategy = strategy;
    }

    @Override
    public boolean hasSpaceAvailable() {
        lock.lock();
        try {
            for(int i=0;i<fourWheelerParkingSpots.size();i++){
                if(fourWheelerParkingSpots.get(i).isFree()){
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
            ParkingSpot parkingSpot= strategy.selectSpot(fourWheelerParkingSpots);
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
