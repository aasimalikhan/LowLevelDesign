package org.example.solidprinciples.chainOfResponsibilityPattern.gptCode;

public class gptCode {
    public static void main(String[] args) {
        RequestHandler handler = new Level1RequestHandler(new Level2RequestHandler(new Level3RequestHandler(null)));

        handler.handleRequest(1, "india dev outage");
        handler.handleRequest(2, "vpm not connecting hyderabad");
        handler.handleRequest(3, "global payment gateway outage");

    }
}
