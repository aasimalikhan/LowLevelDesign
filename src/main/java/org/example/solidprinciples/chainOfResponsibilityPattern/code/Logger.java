package org.example.solidprinciples.chainOfResponsibilityPattern.code;

public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    Logger nextLogger;
    Logger(Logger nextLogger)
    {
        this.nextLogger = nextLogger;
    }

    public void log(int severity, String message)
    {
        if(nextLogger != null)
        {
            nextLogger.log(severity, message);
        }
    }


}
