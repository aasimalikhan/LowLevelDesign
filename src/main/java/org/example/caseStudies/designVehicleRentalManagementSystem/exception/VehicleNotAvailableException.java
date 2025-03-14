package org.example.caseStudies.designVehicleRentalManagementSystem.exception;

public class VehicleNotAvailableException extends RuntimeException{
    public VehicleNotAvailableException(String message)
    {
        super(message);
    }
}
