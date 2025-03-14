package org.example.caseStudies.designLoggingFramework.models;

public class ConsoleLogger implements LogObserver{
    @Override
    public void log(String message) {
        System.out.println("CONSOLE: " + message);
    }
}