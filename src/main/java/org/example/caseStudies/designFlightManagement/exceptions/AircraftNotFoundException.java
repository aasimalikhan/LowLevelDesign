package org.example.caseStudies.designFlightManagement.exceptions;

public class AircraftNotFoundException extends Exception{
    public AircraftNotFoundException(String message)
    {
        super(message);
    }
}
