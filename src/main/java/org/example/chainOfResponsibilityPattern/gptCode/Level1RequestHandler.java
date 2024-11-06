package org.example.chainOfResponsibilityPattern.gptCode;

public class Level1RequestHandler extends RequestHandler{
    public Level1RequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(int severity, String message)
    {
        if(severity == 1)
        {
            System.out.println("LEVEL1 SUPPORT: HANDLING REQUEST -> " + message);
        }
        else {
            super.handleRequest(severity, message);
        }
    }
}
