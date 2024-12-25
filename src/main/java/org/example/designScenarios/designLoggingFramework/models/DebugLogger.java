package org.example.designScenarios.designLoggingFramework.models;

public class DebugLogger extends AbstractLogger{
    public DebugLogger(int level)
    {
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String finalMessage = "DEBUG: " + message;
        logSubject.notifyAllObserver(3, finalMessage);
    }
}