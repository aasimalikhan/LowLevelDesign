package org.example.UTILS_CODE.logger;

public class InfoLogger extends Logger{
    public InfoLogger(Logger nextLogger)
    {
        super(nextLogger);
    }
    @Override
    public void log(int severity, String message)
    {
        if(severity == INFO)
        {
            System.out.println("INFO: " + message);
        }
        else {
            super.log(severity, message);
        }
    }
}
