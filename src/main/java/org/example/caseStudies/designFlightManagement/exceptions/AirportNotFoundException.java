package org.example.caseStudies.designFlightManagement.exceptions;

public class AirportNotFoundException extends Exception{
    public AirportNotFoundException(String message)
    {
        super(message);
    }
}

