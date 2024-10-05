package org.example.solidprinciples.chainOfResponsibilityPattern.gptCode;

public class Level2RequestHandler extends RequestHandler{
    public Level2RequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(int severity, String message)
    {
        if(severity == 2)
        {
            System.out.println("LEVEL2 SUPPORT: HANDLING REQUEST -> " + message);
        }
        else
        {
            super.handleRequest(severity, message);
        }
    }
}
