package org.example.solidprinciples.strategyDesignPattern.goodCode;

public class OffroadVehicle extends Vehicle{
    public OffroadVehicle(DriveStrategy strategy) {
        super(strategy);
    }
}
