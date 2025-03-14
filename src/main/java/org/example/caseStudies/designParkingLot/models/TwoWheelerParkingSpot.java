package org.example.caseStudies.designParkingLot.models;

public class TwoWheelerParkingSpot extends ParkingSpot{
    private static double hourlyRate = 20;
    private static double minutelyRate = 0.3;
    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double getMinutelyRate() {
        return minutelyRate;
    }
}
