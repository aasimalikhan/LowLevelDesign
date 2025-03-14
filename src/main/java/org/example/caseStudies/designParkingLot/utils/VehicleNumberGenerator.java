package org.example.caseStudies.designParkingLot.utils;

import java.util.Random;

public class VehicleNumberGenerator {

    private static final String[] STATES = {"AP", "TS", "KA", "MH", "DL", "TN", "WB", "RJ"};
    private static final String[] VEHICLE_TYPES = {"AX", "SG", "PV", "PL"}; // State Govt, Police, Private Vehicles

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) { // Generate 5 random vehicle numbers
            System.out.println(generateVehicleNumber());
        }
    }

    public static String generateVehicleNumber() {
        Random random = new Random();

        // Randomly select state code
        String stateCode = STATES[random.nextInt(STATES.length)];

        // Generate random region code (2-digit number)
        int regionCode = random.nextInt(99) + 1; // Range: 01 to 99
        String regionCodeFormatted = String.format("%02d", regionCode);

        // Randomly select vehicle type
        String vehicleType = VEHICLE_TYPES[random.nextInt(VEHICLE_TYPES.length)];

        // Generate random vehicle number (4-digit number)
        int vehicleNumber = random.nextInt(9999) + 1; // Range: 0001 to 9999
        String vehicleNumberFormatted = String.format("%04d", vehicleNumber);

        // Combine all parts
        return stateCode + regionCodeFormatted + " " + vehicleType + " " + vehicleNumberFormatted;
    }
}
