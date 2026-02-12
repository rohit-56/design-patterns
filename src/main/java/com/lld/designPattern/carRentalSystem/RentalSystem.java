package com.lld.designPattern.carRentalSystem;

import com.lld.designPattern.carRentalSystem.enums.ReservationStatus;
import com.lld.designPattern.carRentalSystem.enums.Status;
import com.lld.designPattern.carRentalSystem.model.*;

import java.util.List;

public class RentalSystem {

    public RentalSystem() {

        //Setup First Store in Kanpur City

        Location kanpur = new Location(1,"Kanpur","Indra Nagar",208002);
        Store store1 = new Store(1,kanpur);

        //Add Vehicles
        //Add Two Cars

        Vehicle swift = new Car(1,"Maruti","white","xyz",200,"ABC",4);

        Vehicle wagon = new Car(2,"Maruti","red","xyz",100,"DEF",4);

        store1.vehicleInventory.addVehicle(swift);
        store1.vehicleInventory.addVehicle(wagon);

        //Add Bike
        Vehicle bike1 = new Bike(3,"Hero","Blue","Latest",50,"UP78",1);

        store1.vehicleInventory.addVehicle(bike1);

        //Setup Second Store in Noida City

        Location noida = new Location(2,"Noida","Sector-57",208001);
        Store store2 = new Store(2,noida);

        //Add Vehicles
        //Add Two Cars

        Vehicle thar = new Car(1,"Thar","black","L1",500,"ABC1",4);

        Vehicle creta = new Car(2,"Creta","white","Z1",300,"DEF1",4);

        store2.vehicleInventory.addVehicle(swift);
        store2.vehicleInventory.addVehicle(wagon);

        //Add Bike
        Vehicle bike2 = new Bike(3,"Bajaj","Black","LKL-100",100,"UP",1);

        store2.vehicleInventory.addVehicle(bike1);


        //Print Stores with their available Vehicles

        System.out.println("List of avaiable vehicles in "+store1.location.city+" -----------");
        System.out.println("-----------------------------------------------------------------------");
        List<Vehicle> vehicleList = store1.vehicleInventory.getAvailableVehicles();
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.vehicleId+" "+vehicle.company+" "+vehicle.status+" "+ vehicle.hourlyCost);
        }


        User rohit = new User(1,"Rohit","rohitmou25@gmail.com","892","DLof091");

        Reservation r1 = new Reservation(1,swift,"02-02-2026","08-02-2026", ReservationStatus.INPROGRESS,kanpur);


        store1.addReservation(r1);

        vehicleList = store1.vehicleInventory.getAvailableVehicles();
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.vehicleId+" "+vehicle.company+" "+vehicle.status+" "+ vehicle.hourlyCost);
        }




    }
}
