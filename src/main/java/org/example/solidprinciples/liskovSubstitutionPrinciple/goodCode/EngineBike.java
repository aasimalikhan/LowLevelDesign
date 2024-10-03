package org.example.solidprinciples.liskovSubstitutionPrinciple.goodCode;

public class EngineBike implements Bike{
    boolean isEngineOn;
    @Override
    public void accelerate() {
        //bike accelerating by throttle
    }

    public void turnOnEngine()
    {
        isEngineOn = true;
    }
}
