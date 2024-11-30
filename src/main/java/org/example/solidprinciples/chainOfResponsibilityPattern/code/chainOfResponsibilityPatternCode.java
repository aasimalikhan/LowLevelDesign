package org.example.solidprinciples.chainOfResponsibilityPattern.code;

public class chainOfResponsibilityPatternCode {
    public static void main(String[] args) {
        Logger logger = (new DebugLogger(new ErrorLogger(new InfoLogger(null))));
        logger.log(1, "REST API response from localhost:3000/users loaded");
    }
}
