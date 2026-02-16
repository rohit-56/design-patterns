package com.lld.designPattern.parkinglot.gate;

import com.lld.designPattern.parkinglot.building.ParkingBuilding;
import com.lld.designPattern.parkinglot.entity.Payment;
import com.lld.designPattern.parkinglot.entity.Ticket;
import com.lld.designPattern.parkinglot.pricing.CostComputation;

public class Exit {
   public CostComputation costComputation;

   public Exit(CostComputation costComputation){
       this.costComputation = costComputation;
   }
    public void exitCompletion(ParkingBuilding parkingBuilding,Ticket ticket, Payment payment){
       double amount = costComputation.getAmount(ticket);

       //payment.pay(amount)

        System.out.println("Parking Amount for Vehicle Number "+ticket.getVehicle().getVehicleNumber()+" is: "+amount);

        parkingBuilding.releaseSpot(ticket);

        System.out.println("Vehicle Exit");
    }
}
