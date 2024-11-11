package org.example.solidprinciples.singletonDesignPattern.LazyInitialization;

public class Main {
    public static void main(String[] args) {
        DBConnection conObject1 = DBConnection.getInstance();
        DBConnection conObject2 = DBConnection.getInstance();

        System.out.println(System.identityHashCode(conObject1));
        System.out.println(System.identityHashCode(conObject2));
    }
}
