package org.example.caseStudies.designFlightManagement.strategy.pricing;

import org.example.caseStudies.designFlightManagement.models.FlightInstance;
import org.example.caseStudies.designFlightManagement.models.Seat;

public interface PricingStrategy {
    public double getAmount(FlightInstance flight, Seat seat);
}
