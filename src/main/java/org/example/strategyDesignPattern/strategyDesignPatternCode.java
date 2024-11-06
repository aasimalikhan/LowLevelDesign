package org.example.strategyDesignPattern;

import org.example.strategyDesignPattern.goodCode.*;

public class strategyDesignPatternCode {
    public static void main(String[] args) {
        DriveStrategy specialDriveStrategy = new SpecialDriveStrategy();
        DriveStrategy normalDriveStrategy = new NormalDriveStrategy();
        Vehicle vehicle1 = new PassengerVehicle(normalDriveStrategy);
        Vehicle vehicle2 = new OffroadVehicle(specialDriveStrategy);

        System.out.println("passenger vehicle driving: ");
        vehicle1.strategy.drive();
        System.out.println("offroad vehicle driving: ");
        vehicle2.strategy.drive();
    }
}
