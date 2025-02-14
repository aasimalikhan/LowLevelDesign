package org.example.designScenarios.designFlightManagement;

public class Main {
    public static void main(String[] args) {
        FlightManagementSystem FMS = new FlightManagementSystem();
        FMS.printFlights();
        FMS.printAirports();
        FMS.printAircraft();
    }
}
