package org.example.designScenarios.designFlightManagement.exceptions;

public class AircraftAlreadyExistsException extends Exception{
    public AircraftAlreadyExistsException(String message){
        super(message);
    }
}
