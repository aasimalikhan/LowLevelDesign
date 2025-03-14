package org.example.caseStudies.designParkingLot.config;

public class ParkingConfig {
    private static final int MAX_TWO_WHEELER_SPACES = 100;
    private static final int MAX_FOUR_WHEELER_SPACES = 200;
    public static int getMaxTwoWheelerSpaces() {
        return MAX_TWO_WHEELER_SPACES;
    }
    public static int getMaxFourWheelerSpaces() {
        return MAX_FOUR_WHEELER_SPACES;
    }
}
