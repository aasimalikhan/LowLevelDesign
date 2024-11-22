package org.example.designScenarios.designVehicleRentalManagementSystem.exception;

public class VehicleNotAvailableException extends RuntimeException{
    public VehicleNotAvailableException(String message)
    {
        super(message);
    }
}
