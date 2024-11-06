package org.example.strategyDesignPattern.goodCode;

public class Vehicle {
    public DriveStrategy strategy;
    public Vehicle(DriveStrategy strategy)
    {
        this.strategy = strategy;
    }
}
