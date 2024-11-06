package org.example.strategyDesignPattern.goodCode;

public class SpecialDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("drive in special mode");
    }
}
