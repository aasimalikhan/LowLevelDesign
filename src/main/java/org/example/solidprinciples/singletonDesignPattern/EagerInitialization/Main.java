package org.example.solidprinciples.singletonDesignPattern.EagerInitialization;

public class Main {
    public static void main(String[] args) {
        DBConnection conObject = DBConnection.getInstance();

    }
}
