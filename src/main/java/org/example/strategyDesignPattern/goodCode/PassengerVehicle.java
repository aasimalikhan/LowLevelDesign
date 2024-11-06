package org.example.strategyDesignPattern.goodCode;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle(DriveStrategy strategy) {
        super(strategy);
    }
}
