package org.example.UTILS_CODE.logger;

public class DebugLogger extends Logger{
    public DebugLogger(Logger nextLogger)
    {
        super(nextLogger);
    }
    @Override
    public void log(int severity, String message)
    {
        if(severity == DEBUG)
        {
            System.out.println("DEBUG: " + message);
        }
        else {
            super.log(severity, message);
        }
    }
}
