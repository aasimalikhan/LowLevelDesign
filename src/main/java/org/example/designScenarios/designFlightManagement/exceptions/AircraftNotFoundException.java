package org.example.designScenarios.designFlightManagement.exceptions;

public class AircraftNotFoundException extends Exception{
    public AircraftNotFoundException(String message)
    {
        super(message);
    }
}
