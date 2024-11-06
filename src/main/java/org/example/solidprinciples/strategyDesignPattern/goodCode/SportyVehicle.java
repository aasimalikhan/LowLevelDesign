package org.example.solidprinciples.strategyDesignPattern.goodCode;

public class SportyVehicle extends Vehicle{
    public SportyVehicle(DriveStrategy strategy) {
        super(strategy);
    }
}
