package org.example.solidprinciples.strategyDesignPattern.goodCode;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle(DriveStrategy strategy) {
        super(strategy);
    }
}
