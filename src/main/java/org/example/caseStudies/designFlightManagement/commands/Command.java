package org.example.caseStudies.designFlightManagement.commands;

public interface Command<Request, Response> {
    public Response execute() throws Exception;
}
