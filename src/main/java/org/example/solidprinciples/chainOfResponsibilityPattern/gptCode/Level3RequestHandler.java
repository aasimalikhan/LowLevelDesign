package org.example.solidprinciples.chainOfResponsibilityPattern.gptCode;

public class Level3RequestHandler extends RequestHandler{
    public Level3RequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(int severity, String message)
    {
        if(severity == 3)
        {
            System.out.println("LEVEL3 SUPPORT: HANDLING REQUEST -> " + message);
        }
        else {
            super.handleRequest(severity, message);
        }
    }
}
