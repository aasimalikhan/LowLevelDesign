package org.example.designScenarios.designParkingLot.models;

import org.example.designScenarios.designParkingLot.factory.ParkingManagerFactory;
import org.example.designScenarios.designParkingLot.managers.ParkingSpotManager;
import org.example.designScenarios.designParkingLot.strategy.pricing.PricingStrategy;

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
