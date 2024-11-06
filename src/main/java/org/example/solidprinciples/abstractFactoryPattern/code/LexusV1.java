package org.example.solidprinciples.abstractFactoryPattern.code;

public class LexusV1 extends LuxuryVehicle{
    @Override
    public void drive() {
        System.out.println("Driving Lexus1");
        luxuryStuff();
    }
}
