package org.example.caseStudies.designLoggingFramework.models;

public class InfoLogger extends AbstractLogger{
    public InfoLogger(int level)
    {
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String finalMessage = "DEBUG: " + message;
        logSubject.notifyAllObserver(1, finalMessage);
    }
}
