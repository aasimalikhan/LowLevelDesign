package org.example.chainOfResponsibilityPattern.code;

public class InfoLogger extends Logger{
    InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int severity, String message)
    {
        if(severity == INFO)
        {
            System.out.println("INFO: " + message);
        }
        else
        {
            super.log(severity, message);
        }
    }
}
