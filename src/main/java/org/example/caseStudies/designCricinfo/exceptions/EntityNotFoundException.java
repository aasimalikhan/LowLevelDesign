package org.example.caseStudies.designCricinfo.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityType, String id) {
        super(String.format("%s with ID %s not found", entityType, id));
    }
}
