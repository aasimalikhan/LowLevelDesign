package org.example.designScenarios.designParkingLot.managers;

import org.example.designScenarios.designParkingLot.config.ParkingConfig;
import org.example.designScenarios.designParkingLot.exceptions.ParkingSpotLimitReachedException;
import org.example.designScenarios.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.designScenarios.designParkingLot.models.ParkingSpot;
import org.example.designScenarios.designParkingLot.models.TwoWheelerParkingSpot;
import org.example.designScenarios.designParkingLot.models.Vehicle;
import org.example.designScenarios.designParkingLot.strategy.parking.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager{
//    List<ParkingSpot> parkingSpots;
    ParkingStrategy parkingStrategy;

    public TwoWheelerParkingSpotManager(ParkingStrategy parkingStrategy) {
        this.parkingSpots = new ArrayList<>();
        this.parkingStrategy = parkingStrategy;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public ParkingSpot findParkingSpace() throws ParkingSpotNotFoundException {
        return parkingStrategy.findParkingSpot(parkingSpots);
    }

    @Override
    public void addParkingSpace() throws ParkingSpotLimitReachedException {
        if(parkingSpots.size() < ParkingConfig.getMaxTwoWheelerSpaces()) {
            ParkingSpot newParkingSpot = new TwoWheelerParkingSpot();
            parkingSpots.add(newParkingSpot);
        }
        else {
            throw new ParkingSpotLimitReachedException("No more parking spots");
        }
    }

    @Override
    public void removeParkingSpace(long id) {
        parkingSpots.removeIf(item -> item.getId() == id);
    }

    @Override
    public void parkVehicle(Vehicle vehicle) throws ParkingSpotNotFoundException {
        ParkingSpot parkingSpot = findParkingSpace();
        parkingSpot.setVehicle(vehicle);
        parkingSpot.setEmpty(false);
    }

    @Override
    public void unparkVehicle(ParkingSpot parkingSpot) {
        parkingSpot.setEmpty(true);
        parkingSpot.setVehicle(null);
    }

    public int getEmptySpaces()
    {
        return parkingSpots.stream().filter(spot -> spot.isEmpty() == true).collect(Collectors.toUnmodifiableList()).size();
    }
}
