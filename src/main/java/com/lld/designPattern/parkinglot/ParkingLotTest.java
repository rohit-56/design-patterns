package com.lld.designPattern.parkinglot;

import com.lld.designPattern.parkinglot.building.ParkingBuilding;
import com.lld.designPattern.parkinglot.building.ParkingLevel;
import com.lld.designPattern.parkinglot.entity.*;
import com.lld.designPattern.parkinglot.gate.Entrance;
import com.lld.designPattern.parkinglot.gate.Exit;
import com.lld.designPattern.parkinglot.lookupStrategy.RandomParkingSpotLookupStrategy;
import com.lld.designPattern.parkinglot.manager.BikeParkingSpotManager;
import com.lld.designPattern.parkinglot.manager.CarParkingSpotManager;
import com.lld.designPattern.parkinglot.manager.ParkingSpotManager;
import com.lld.designPattern.parkinglot.pricing.CostComputation;
import com.lld.designPattern.parkinglot.pricing.FixedPricingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotTest {
    public static ParkingSystem parkingSystem;

    public ParkingLotTest(){
        this.parkingSystem=initialize();

        test();
    }

    public ParkingSystem initialize(){
        //1.Create Parking Spot for bikes

        List<ParkingSpot> parkingSpotList=new ArrayList<ParkingSpot>();
        parkingSpotList.add(new ParkingSpot("B1"));
        parkingSpotList.add(new ParkingSpot("B2"));
        parkingSpotList.add(new ParkingSpot("B3"));

        //2.Create Two Wheeler Parking Manager and add this list
        BikeParkingSpotManager bikeParkingSpotManager = new BikeParkingSpotManager(parkingSpotList,new RandomParkingSpotLookupStrategy());

        //3.Create Parking Spot for Cars
        List<ParkingSpot> carParkingSpotList=new ArrayList<ParkingSpot>();
        carParkingSpotList.add(new ParkingSpot("C1"));
        carParkingSpotList.add(new ParkingSpot("C2"));

        //4.Create Four wheeler Parking manager and add this list
        CarParkingSpotManager carParkingSpotManager=new CarParkingSpotManager(carParkingSpotList,new RandomParkingSpotLookupStrategy());

        //5.Create map for parking managers
        Map<VehicleType, ParkingSpotManager> managers = new HashMap<>();
        managers.put(VehicleType.CAR,carParkingSpotManager);
        managers.put(VehicleType.BIKE,bikeParkingSpotManager);

        //Create level
        ParkingLevel level1=new ParkingLevel(1,managers);
        List<ParkingLevel> parkingLevelList=new ArrayList<>();
        parkingLevelList.add(level1);
        //Create Building and add level
        ParkingBuilding building = new ParkingBuilding(parkingLevelList);

        //Create Entrance
        Entrance entrance = new Entrance();
        //Create Exit
        Exit exit = new Exit(new CostComputation(new FixedPricingStrategy()));

        //return parking system object
        return new ParkingSystem(building,entrance,exit);
    }
    public void test(){
        Vehicle vehicle = new Vehicle("AE 2678",VehicleType.BIKE);

        System.out.println(""+vehicle.getVehicleNumber() +" has arrived at entrance");
        System.out.println("----------------------------------------------------");
        System.out.println("Check Availablity");
        Ticket ticket = parkingSystem.vehicleArrives(vehicle);
        if(ticket==null){
            System.out.println("No space found");
        }
        else{
            System.out.println("Ticket generated ");
            System.out.println(ticket.getTicketId()+" "+ticket.getParkingLevel().levelNumber+" "+ticket.getParkingSpot().getSpotNumber());

            parkingSystem.vehicleExit(ticket,new Payment());
        }
    }

}
