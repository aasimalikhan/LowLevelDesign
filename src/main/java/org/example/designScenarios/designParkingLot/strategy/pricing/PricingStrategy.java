package org.example.designScenarios.designParkingLot.strategy.pricing;

import org.example.designScenarios.designParkingLot.models.ParkingSpot;
import org.example.designScenarios.designParkingLot.models.Ticket;

public interface PricingStrategy {
    double getPrice(Ticket ticket, ParkingSpot spot);
}
