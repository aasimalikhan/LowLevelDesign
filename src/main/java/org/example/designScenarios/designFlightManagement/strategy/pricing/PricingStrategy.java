package org.example.designScenarios.designFlightManagement.strategy.pricing;

import org.example.designScenarios.designFlightManagement.models.FlightInstance;
import org.example.designScenarios.designFlightManagement.models.Seat;

public interface PricingStrategy {
    public double getAmount(FlightInstance flight, Seat seat);
}
