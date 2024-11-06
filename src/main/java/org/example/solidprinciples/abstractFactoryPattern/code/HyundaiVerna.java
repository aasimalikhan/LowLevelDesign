package org.example.solidprinciples.abstractFactoryPattern.code;

public class HyundaiVerna extends OrdinaryVehicle{
    @Override
    public void drive() {
        System.out.println("Driving Hyundai Verna");
        ordinaryStuff();
    }
}
