package org.example.solidprinciples.chainOfResponsibilityPattern.code;

public class DebugLogger extends Logger{
    DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int severity, String message)
    {
        if(severity == DEBUG)
        {
            System.out.println("DEBUG: " + message);
        }
        else
        {
            super.log(severity, message);
        }
    }
}
