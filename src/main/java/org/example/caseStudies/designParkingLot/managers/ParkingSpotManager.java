package org.example.caseStudies.designParkingLot.managers;

import org.example.caseStudies.designParkingLot.exceptions.ParkingSpotLimitReachedException;
import org.example.caseStudies.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.caseStudies.designParkingLot.models.ParkingSpot;
import org.example.caseStudies.designParkingLot.models.Vehicle;
import org.example.caseStudies.designParkingLot.strategy.parking.ParkingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;
    private static int idCounter = 1;
    protected ParkingStrategy parkingStrategy;

    public abstract ParkingSpot findParkingSpace() throws ParkingSpotNotFoundException;
    public abstract void addParkingSpace() throws ParkingSpotLimitReachedException;
    public abstract void removeParkingSpace(long id);
    public abstract void parkVehicle(Vehicle vehicle) throws ParkingSpotNotFoundException;
    public abstract void unparkVehicle(ParkingSpot parkinggSpot);
    public int getEmptySpaces() {
        return parkingSpots.stream().filter(spot -> spot.isEmpty() == true).collect(Collectors.toUnmodifiableList()).size();
    }
}
