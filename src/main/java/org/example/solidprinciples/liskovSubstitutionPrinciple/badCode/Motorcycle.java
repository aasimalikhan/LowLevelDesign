package org.example.solidprinciples.liskovSubstitutionPrinciple.badCode;

public class Motorcycle implements Bike{
    boolean isEngineOn;
    int speed;
    @Override
    public void turnOnEngine() {
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        speed += 10;
    }
}
