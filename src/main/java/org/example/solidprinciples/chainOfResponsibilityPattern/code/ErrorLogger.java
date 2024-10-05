package org.example.solidprinciples.chainOfResponsibilityPattern.code;

public class ErrorLogger extends Logger{
    ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int severity, String message)
    {
        if(severity == ERROR)
        {
            System.out.println("ERROR: " + message);
        }
        else
        {
            super.log(severity, message);
        }
    }
}
