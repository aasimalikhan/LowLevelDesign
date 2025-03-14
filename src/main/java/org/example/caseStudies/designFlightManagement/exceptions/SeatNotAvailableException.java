package org.example.caseStudies.designFlightManagement.exceptions;

public class SeatNotAvailableException extends Exception{
    public SeatNotAvailableException(String message)
    {
        super(message);
    }
}
