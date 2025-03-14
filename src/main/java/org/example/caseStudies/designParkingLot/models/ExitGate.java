package org.example.caseStudies.designParkingLot.models;

import org.example.caseStudies.designParkingLot.factory.ParkingManagerFactory;
import org.example.caseStudies.designParkingLot.managers.ParkingSpotManager;
import org.example.caseStudies.designParkingLot.strategy.pricing.PricingStrategy;

public class ExitGate {
    PricingStrategy pricingStrategy;
    ParkingSpotManager parkingSpotManager;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculatePrice(Ticket ticket)
    {
        return pricingStrategy.getPrice(ticket, ticket.getSpot());
    }

    public boolean payment()
    {
        return true;
    }
    public void unparkVehicle(Ticket ticket)
    {
        this.parkingSpotManager = ParkingManagerFactory.getParkingSpotManager(ticket.getVehicle().getVehicleType());
        ParkingSpot spot = ticket.getSpot();
        parkingSpotManager.unparkVehicle(spot);
    }
}
