package org.example.designScenarios.designParkingLot.managers;

import org.example.designScenarios.designParkingLot.models.ParkingSpot;
import org.example.designScenarios.designParkingLot.models.Vehicle;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{
    List<ParkingSpot> parkingSpots;
    @Override
    public ParkingSpot findParkingSpace() {
        return null;
    }

    @Override
    public void addParkingSpace() {

    }

    @Override
    public void removeParkingSpace(long id) {

    }

    @Override
    public void parkVehicle(Vehicle vehicle) {

    }

    @Override
    public void unparkVehicle(ParkingSpot parkinggSpot) {

    }
}
