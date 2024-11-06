package org.example.solidprinciples.abstractFactoryPattern.code;

public class MahindraThar extends OrdinaryVehicle{

    @Override
    public void drive() {
        System.out.println("Driving Mahindra Thar");
        ordinaryStuff();
    }
}
