package org.example.caseStudies.designParkingLot.strategy.pricing;

import org.example.caseStudies.designParkingLot.models.ParkingSpot;
import org.example.caseStudies.designParkingLot.models.Ticket;

public interface PricingStrategy {
    double getPrice(Ticket ticket, ParkingSpot spot);
}
