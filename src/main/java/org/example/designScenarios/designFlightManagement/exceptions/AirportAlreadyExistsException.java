package org.example.designScenarios.designFlightManagement.exceptions;

public class AirportAlreadyExistsException extends Exception{
    public AirportAlreadyExistsException(String message)
    {
        super(message);
    }
}
