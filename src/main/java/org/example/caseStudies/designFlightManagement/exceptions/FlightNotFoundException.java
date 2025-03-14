package org.example.caseStudies.designFlightManagement.exceptions;

public class FlightNotFoundException extends Exception {
    public FlightNotFoundException(String message)
    {
        super(message);
    }
}
