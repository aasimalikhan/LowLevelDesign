package org.example.solidprinciples.liskovSubstitutionPrinciple.badCode;

public class Bicycle implements Bike{
    @Override
    public void turnOnEngine() {
        throw new AssertionError("there is no engine");
    }

    @Override
    public void accelerate() {

    }
}
