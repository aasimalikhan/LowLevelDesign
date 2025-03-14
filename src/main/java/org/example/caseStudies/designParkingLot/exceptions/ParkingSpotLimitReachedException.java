package org.example.caseStudies.designParkingLot.exceptions;

public class ParkingSpotLimitReachedException extends Exception{
    public ParkingSpotLimitReachedException(String message) {
        super(message);
    }
}
