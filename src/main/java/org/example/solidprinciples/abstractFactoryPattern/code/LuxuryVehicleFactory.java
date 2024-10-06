package org.example.solidprinciples.abstractFactoryPattern.code;

public class LuxuryVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(String vehicle) {
        switch(vehicle)
        {
            case "LEXUS V1": {
                return new LexusV1();
            }
            case "MERCEDES ACLASS":
            {
                return new MercedesAClass();
            }
            default:
                return null;
        }
    }
}
