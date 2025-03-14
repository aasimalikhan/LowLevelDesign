package org.example.caseStudies.designFlightManagement.strategy.pricing;

import org.example.caseStudies.designFlightManagement.models.FlightInstance;
import org.example.caseStudies.designFlightManagement.models.Seat;
import org.example.caseStudies.designFlightManagement.models.SeatClass;
import org.example.caseStudies.designFlightManagement.models.SeatType;

public class StandardPricingStrategy implements PricingStrategy{
    private static final double BASE_PRICE_PER_KM = 0.10;
    @Override
    public double getAmount(FlightInstance flightInstance, Seat seat) {
        if (flightInstance == null || flightInstance.getFlight() == null || seat == null) {
            throw new IllegalArgumentException("Invalid flight instance or seat");
        }
        double basePrice = calculateBasePrice(flightInstance.getFlight().getDistance());
        double classMultiplier = getClassMultiplier(seat.getClassType());
        double seatTypeMultiplier = getSeatTypeMultiplier(seat.getType());

        return basePrice * classMultiplier * seatTypeMultiplier;
    }

    private double getSeatTypeMultiplier(SeatType type) {
        return switch (type) {
            case REGULAR, ACCESSIBLE -> 1.0;
            case EXTRA_LEGROOM -> 1.25;
            case EMERGENCY_EXIT -> 1.15;
        };
    }

    public double calculateBasePrice(double distance)
    {
        return distance * BASE_PRICE_PER_KM;
    }

    public double getClassMultiplier(SeatClass seatClass)
    {
        return switch (seatClass)
        {
            case ECONOMY -> 1.0;
            case ECONOMY_PLUS -> 1.3;
            case PREFERRED_ECONOMY -> 1.5;
            case BUSINESS -> 2.5;
            case FIRST_CLASS -> 4.0;
        };
    }

}
