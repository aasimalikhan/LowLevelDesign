package org.example.caseStudies.designParkingLot.strategy.pricing;

import org.example.caseStudies.designParkingLot.models.ParkingSpot;
import org.example.caseStudies.designParkingLot.models.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourBasedPricingStrategy implements PricingStrategy{
    @Override
    public double getPrice(Ticket ticket, ParkingSpot spot) {
        LocalDateTime entryTime = ticket.getEntryTime();
        Duration timeElapsed = Duration.between(entryTime, LocalDateTime.now());
        double hoursPassed = timeElapsed.toMinutes() / 60.0;
        return hoursPassed * spot.getHourlyRate();
    }
}
