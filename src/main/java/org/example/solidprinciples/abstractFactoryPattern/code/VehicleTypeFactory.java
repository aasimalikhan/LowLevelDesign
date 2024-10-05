package org.example.solidprinciples.abstractFactoryPattern.code;

public class VehicleTypeFactory {
    public VehicleFactory getVehicleFactory(String vehicleType) {
        switch (vehicleType) {
            case "LUXURY": {
                return new LuxuryVehicleFactory();
            }
            case "ORDINARY": {
                return new OrdinaryVehicleFactory();
            }
            default:
            {
                return null;
            }
        }
    }
}
