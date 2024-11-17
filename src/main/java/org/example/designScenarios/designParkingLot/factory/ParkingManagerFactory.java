package org.example.designScenarios.designParkingLot.factory;

import org.example.designScenarios.designParkingLot.managers.FourWheelerParkingSpotManager;
import org.example.designScenarios.designParkingLot.managers.ParkingSpotManager;
import org.example.designScenarios.designParkingLot.managers.TwoWheelerParkingSpotManager;
import org.example.designScenarios.designParkingLot.models.VehicleType;
import org.example.designScenarios.designParkingLot.strategy.parking.DefaultParkingStrategy;

public class ParkingManagerFactory {

    // Single instances for the parking spot managers
    private static ParkingSpotManager twoWheelerParkingManager = null;
    private static ParkingSpotManager fourWheelerParkingManager = null;

    // Method to get the appropriate ParkingSpotManager
    public static ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.TWOWHEELER)) {
            if (twoWheelerParkingManager == null) {
                synchronized (ParkingManagerFactory.class) {
                    if (twoWheelerParkingManager == null) {
                        twoWheelerParkingManager = new TwoWheelerParkingSpotManager(new DefaultParkingStrategy());
                    }
                }
            }
            return twoWheelerParkingManager;
        } else if (vehicleType.equals(VehicleType.FOURWHEELER)) {
            if (fourWheelerParkingManager == null) {
                synchronized (ParkingManagerFactory.class) {
                    if (fourWheelerParkingManager == null) {
                        fourWheelerParkingManager = new FourWheelerParkingSpotManager();
                    }
                }
            }
            return fourWheelerParkingManager;
        }
        throw new IllegalArgumentException("Unsupported Vehicle Type: " + vehicleType);
    }
}
