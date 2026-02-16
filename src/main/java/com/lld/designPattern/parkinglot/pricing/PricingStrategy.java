package com.lld.designPattern.parkinglot.pricing;

import com.lld.designPattern.parkinglot.entity.Ticket;
import com.lld.designPattern.parkinglot.entity.Vehicle;

public interface PricingStrategy {

    public double getPricing(Ticket ticket);
}
