package org.example.caseStudies.designParkingLot.strategy.parking;

import org.example.caseStudies.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.caseStudies.designParkingLot.models.ParkingSpot;

import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) throws ParkingSpotNotFoundException {
        return parkingSpots.stream().filter(spot -> spot.isEmpty()).findFirst().orElseThrow(() -> new ParkingSpotNotFoundException("Unable to find Parking Spot"));
    }
}
