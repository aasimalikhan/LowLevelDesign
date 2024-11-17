package org.example.designScenarios.designParkingLot.strategy.parking;

import org.example.designScenarios.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.designScenarios.designParkingLot.models.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) throws ParkingSpotNotFoundException;
}
