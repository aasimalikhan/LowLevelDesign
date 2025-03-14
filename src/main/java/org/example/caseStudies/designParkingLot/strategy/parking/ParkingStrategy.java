package org.example.caseStudies.designParkingLot.strategy.parking;

import org.example.caseStudies.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.caseStudies.designParkingLot.models.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) throws ParkingSpotNotFoundException;
}
