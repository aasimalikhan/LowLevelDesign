package org.example.caseStudies.designFlightManagement.exceptions;

public class AirportAlreadyExistsException extends Exception{
    public AirportAlreadyExistsException(String message)
    {
        super(message);
    }
}
