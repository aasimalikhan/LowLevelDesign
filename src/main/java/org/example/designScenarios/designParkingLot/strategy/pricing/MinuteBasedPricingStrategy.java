package org.example.designScenarios.designParkingLot.strategy.pricing;

import org.example.designScenarios.designParkingLot.models.ParkingSpot;
import org.example.designScenarios.designParkingLot.models.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinuteBasedPricingStrategy implements PricingStrategy{
    @Override
    public double getPrice(Ticket ticket, ParkingSpot spot) {
        LocalDateTime entryTime = ticket.getEntryTime();
        Duration timeElapsed = Duration.between(entryTime, LocalDateTime.now());
        double minutesPassed = timeElapsed.toMinutes();
        return minutesPassed * spot.getMinutelyRate();
    }
}
