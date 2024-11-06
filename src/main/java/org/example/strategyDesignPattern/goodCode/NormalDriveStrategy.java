package org.example.strategyDesignPattern.goodCode;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("driving in normal mode");
    }
}
