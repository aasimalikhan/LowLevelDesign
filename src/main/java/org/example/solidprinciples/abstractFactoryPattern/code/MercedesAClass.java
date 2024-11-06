package org.example.solidprinciples.abstractFactoryPattern.code;

public class MercedesAClass extends LuxuryVehicle{
    @Override
    public void drive() {
        System.out.println("Driving Mercedes AClass");
        luxuryStuff();
    }
}
