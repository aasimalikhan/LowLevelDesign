package org.example.designScenarios.designParkingLot.strategy.parking;

import org.example.designScenarios.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.designScenarios.designParkingLot.models.ParkingSpot;
import org.example.designScenarios.designParkingLot.models.VehicleType;

import java.util.Comparator;
import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) throws ParkingSpotNotFoundException {
        return parkingSpots.stream().filter(spot -> spot.isEmpty()).findFirst().orElseThrow(() -> new ParkingSpotNotFoundException("Unable to find Parking Spot"));
    }
}
