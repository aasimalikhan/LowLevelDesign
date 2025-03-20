package org.example.caseStudies.designCricinfo.exceptions;

public class DuplicateEntityException extends RuntimeException{
    public DuplicateEntityException(String entityType, String id) {
        super(String.format("%s with ID %s already exists", entityType, id));
    }
}
