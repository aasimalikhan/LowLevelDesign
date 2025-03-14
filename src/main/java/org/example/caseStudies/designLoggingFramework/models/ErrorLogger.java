package org.example.caseStudies.designLoggingFramework.models;

public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level)
    {
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String finalMessage = "ERROR: " + message;
        logSubject.notifyAllObserver(2, finalMessage);
    }
}