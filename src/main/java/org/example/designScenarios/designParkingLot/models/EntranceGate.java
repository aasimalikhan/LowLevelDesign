package org.example.designScenarios.designParkingLot.models;

import org.example.designScenarios.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.designScenarios.designParkingLot.factory.ParkingManagerFactory;
import org.example.designScenarios.designParkingLot.managers.ParkingSpotManager;

public class EntranceGate {
    private ParkingSpotManager parkingSpotManager;
    private ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory();

    public ParkingSpot findParkingSpot(VehicleType vehicleType) throws ParkingSpotNotFoundException {
        this.parkingSpotManager = ParkingManagerFactory.getParkingSpotManager(vehicleType);
        return parkingSpotManager.findParkingSpace();
    }

    public void reserveSpot(Vehicle vehicle, ParkingSpot parkingSpot) throws ParkingSpotNotFoundException {
        parkingSpotManager.parkVehicle(vehicle);

    }

    public Ticket generateTicket(ParkingSpot parkingSpot)
    {
        return new Ticket(parkingSpot);
    }
}
