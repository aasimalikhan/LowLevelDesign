package org.example.designScenarios.designFlightManagement.exceptions;

public class UnsupportedPaymentTypeException extends RuntimeException{
    public UnsupportedPaymentTypeException(String message)
    {
        super(message);
    }
}
