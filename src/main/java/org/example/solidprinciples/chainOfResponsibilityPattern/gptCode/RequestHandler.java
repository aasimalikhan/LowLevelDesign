package org.example.solidprinciples.chainOfResponsibilityPattern.gptCode;

public abstract class RequestHandler {
    public RequestHandler nextHandler;
    public RequestHandler(RequestHandler nextHandler)
    {
        this.nextHandler = nextHandler;
    }
    public void handleRequest(int severity, String message)
    {
        if(nextHandler != null)
        {
            nextHandler.handleRequest(severity, message);
        }
    }
}
