package org.example.caseStudies.designLoggingFramework.models;

public class FileLogger implements LogObserver{
    @Override
    public void log(String message) {
        System.out.println("write to file: " + message);
    }
}
