package org.example.UTILS_CODE.logger;

public class ErrorLogger extends Logger{
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int severity, String message)
    {
        if(severity == ERROR)
        {
            System.out.println("ERROR: " + message);
        }
        else {
            super.log(severity, message);
        }
    }
}
