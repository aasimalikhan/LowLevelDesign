package org.example.caseStudies.designCricinfo.exceptions;

public class BusinessValidationException extends RuntimeException{
    public BusinessValidationException(String message) {
        super(message);
    }
}
