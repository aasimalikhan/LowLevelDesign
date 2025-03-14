package org.example.caseStudies.designFlightManagement.utils;

import java.time.LocalDate;
import java.util.Random;

public class Utility {
    public static final Random random = new Random();
    public static LocalDate generateRandomDOB() {
        int year = 1970 + random.nextInt(30);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return LocalDate.of(year, month, day);
    }

    public static String generateRandomPhoneNumber() {
        return "9" + (100000000 + random.nextInt(900000000));
    }
}
