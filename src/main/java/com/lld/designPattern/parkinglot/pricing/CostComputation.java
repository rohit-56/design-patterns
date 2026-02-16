package com.lld.designPattern.parkinglot.pricing;

import com.lld.designPattern.parkinglot.entity.Ticket;

public class CostComputation {
    public PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }

    public double getAmount(Ticket ticket){
        return pricingStrategy.getPricing(ticket);
    }
}
