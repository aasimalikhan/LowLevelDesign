package org.example.designScenarios.designVehicleRentalManagementSystem.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String message)
    {
        super(message);
    }
}
