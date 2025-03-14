package org.example.caseStudies.designParkingLot.models;

public class FourWheelerParkingSpot extends ParkingSpot{
    private static double hourlyRate = 40;
    private static double minutelyRate = 0.4;
    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double getMinutelyRate() {
        return minutelyRate;
    }
}
