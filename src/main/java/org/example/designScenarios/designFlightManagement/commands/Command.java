package org.example.designScenarios.designFlightManagement.commands;

public interface Command<Request, Response> {
    public Response execute() throws Exception;
}
