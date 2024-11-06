package org.example.code;

public class abstractFactoryPatternCode {
    public static void main(String[] args) {
        VehicleFactory luxuryVehicleFactory = new VehicleTypeFactory().getVehicleFactory("LUXURY");
        Vehicle mercedesAClass = luxuryVehicleFactory.getVehicle("MERCEDES ACLASS");
        mercedesAClass.drive();
    }
}
