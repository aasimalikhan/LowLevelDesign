package org.example.chainOfResponsibilityPattern.code;

public class chainOfResponsibilityPatternCode {
    public static void main(String[] args) {
        Logger logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));

    }
}
