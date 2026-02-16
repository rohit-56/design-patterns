package com.lld.designPattern.parkinglot.pricing;

import com.lld.designPattern.parkinglot.entity.Ticket;

public class FixedPricingStrategy implements  PricingStrategy{
    @Override
    public double getPricing(Ticket ticket) {
        return 180.00;
    }
}
