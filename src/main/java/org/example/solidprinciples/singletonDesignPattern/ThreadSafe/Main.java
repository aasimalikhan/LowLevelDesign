package org.example.solidprinciples.singletonDesignPattern.ThreadSafe;

public class Main {
    public static void main(String[] args) {
        DBConnection connObject = DBConnection.getInstance();
    }
}
