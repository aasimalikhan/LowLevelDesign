package org.example.caseStudies.designVehicleRentalManagementSystem;

import org.example.caseStudies.designVehicleRentalManagementSystem.models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class designVehicleRentalManagementSystem {

    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return "null";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm");
        return dateTime.format(formatter);
    }
    public static void main(String[] args) {
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();
        List<Store> stores = vehicleRentalSystem.getStoreManager().getAllStores();
        List<User> users = vehicleRentalSystem.getUserManager().getAllUsers();

        User user1 = new User("aasim", "1234567890");
        User user2 = new User("emaad", "9987654321");
        User user3 = new User("arshad", "9876512345");
        User user4 = new User("rida", "7766551234");

        vehicleRentalSystem.getUserManager().addUser(user1);
        vehicleRentalSystem.getUserManager().addUser(user2);
        vehicleRentalSystem.getUserManager().addUser(user3);
        vehicleRentalSystem.getUserManager().addUser(user4);

        Location bengaluru = new Location(
                "No. 5, M.G. Road",
                "Near Trinity Circle",
                "560001",
                "Karnataka",
                "Bengaluru"
        );
        bengaluru.setLatitude(12.9715987);
        bengaluru.setLongitude(77.5945627);

        Location mumbai = new Location(
                "Nariman Point",
                "Opp. Marine Drive",
                "400021",
                "Maharashtra",
                "Mumbai"
        );
        mumbai.setLatitude(18.922003);
        mumbai.setLongitude(72.833883);

        Location delhi = new Location(
                "Connaught Place",
                "Block A",
                "110001",
                "Delhi",
                "New Delhi"
        );
        delhi.setLatitude(28.631451);
        delhi.setLongitude(77.216667);

        Location kolkata = new Location(
                "Park Street",
                "Near Indian Museum",
                "700016",
                "West Bengal",
                "Kolkata"
        );
        kolkata.setLatitude(22.554285);
        kolkata.setLongitude(88.351571);

        Store bengaluruStore1 = new Store(bengaluru);
        Store mumbaiStore1 = new Store(mumbai);
        Store delhiStore1 = new Store(delhi);
        Store kolkataStore1 = new Store(kolkata);

        vehicleRentalSystem.getStoreManager().addStore(bengaluruStore1);
        vehicleRentalSystem.getStoreManager().addStore(mumbaiStore1);
        vehicleRentalSystem.getStoreManager().addStore(delhiStore1);
        vehicleRentalSystem.getStoreManager().addStore(kolkataStore1);

        Calendar calendar = Calendar.getInstance();

        calendar.set(2020, Calendar.JANUARY, 5);
        Bike bike1 = new Bike(
                "KA01AB1234",
                VehicleType.TWOWHEELER,
                "Hero",
                "Splendor Plus",
                5000,
                calendar.getTime(),
                400,
                50,
                VehicleStatus.ACTIVE
        );

        calendar.set(2021, Calendar.FEBRUARY, 10);
        Bike bike2 = new Bike(
                "MH12CD5678",
                VehicleType.TWOWHEELER,
                "Bajaj",
                "Pulsar 150",
                8000,
                calendar.getTime(),
                500,
                60,
                VehicleStatus.ACTIVE
        );

        calendar.set(2019, Calendar.MARCH, 15);
        Bike bike3 = new Bike(
                "DL04EF9012",
                VehicleType.TWOWHEELER,
                "TVS",
                "Apache RTR 160",
                12000,
                calendar.getTime(),
                550,
                70,
                VehicleStatus.ACTIVE
        );

        calendar.set(2020, Calendar.APRIL, 20);
        Bike bike4 = new Bike(
                "TN09GH3456",
                VehicleType.TWOWHEELER,
                "Royal Enfield",
                "Classic 350",
                15000,
                calendar.getTime(),
                800,
                100,
                VehicleStatus.ACTIVE
        );

        calendar.set(2018, Calendar.MAY, 25);
        Bike bike5 = new Bike(
                "GJ05IJ7890",
                VehicleType.TWOWHEELER,
                "Yamaha",
                "FZ-S",
                18000,
                calendar.getTime(),
                600,
                75,
                VehicleStatus.ACTIVE
        );

        calendar.set(2021, Calendar.JUNE, 30);
        Bike bike6 = new Bike(
                "UP32KL1234",
                VehicleType.TWOWHEELER,
                "Honda",
                "Activa 6G",
                3000,
                calendar.getTime(),
                350,
                40,
                VehicleStatus.ACTIVE
        );

        calendar.set(2019, Calendar.JULY, 10);
        Bike bike7 = new Bike(
                "AP07MN5678",
                VehicleType.TWOWHEELER,
                "Suzuki",
                "Gixxer SF",
                7000,
                calendar.getTime(),
                500,
                65,
                VehicleStatus.ACTIVE
        );

        calendar.set(2020, Calendar.AUGUST, 15);
        Bike bike8 = new Bike(
                "HR26OP9012",
                VehicleType.TWOWHEELER,
                "KTM",
                "Duke 200",
                10000,
                calendar.getTime(),
                750,
                90,
                VehicleStatus.ACTIVE
        );

        calendar.set(2017, Calendar.SEPTEMBER, 20);
        Bike bike9 = new Bike(
                "WB20QR3456",
                VehicleType.TWOWHEELER,
                "Honda",
                "Hornet 2.0",
                20000,
                calendar.getTime(),
                650,
                80,
                VehicleStatus.ACTIVE
        );

        calendar.set(2021, Calendar.OCTOBER, 5);
        Bike bike10 = new Bike(
                "RJ14ST7890",
                VehicleType.TWOWHEELER,
                "Royal Enfield",
                "Himalayan",
                9000,
                calendar.getTime(),
                850,
                110,
                VehicleStatus.ACTIVE
        );

        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike1);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike2);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike3);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike4);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike5);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike6);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike7);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike8);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike9);
        vehicleRentalSystem.getStoreManager().getStoreById("101").getInventory().addVehicle(bike10);

        ReservationManager reservationManager = new ReservationManager();
        Date bookingDate = new Date(); // Current date
        Date dateBookedFrom = new Date(bookingDate.getTime() + 2 * 24 * 60 * 60 * 1000L); // 2 days later
        Date dateBookedTill = new Date(dateBookedFrom.getTime() + 3 * 24 * 60 * 60 * 1000L); // 3 days after dateBookedFrom
        LocalDateTime fromTime = LocalDateTime.now().plusDays(2).withHour(9).withMinute(0); // 9 AM, 2 days later
        LocalDateTime toTime = fromTime.plusDays(3).withHour(18); // 6 PM, 3 days after fromTime

        // Creating reservation
        Reservation reservation1 = new Reservation(
                101, // Reservation ID, not used since auto-generated
                user1,
                bike1,
                bookingDate,
                dateBookedFrom,
                dateBookedTill,
                bengaluru,
                fromTime,
                toTime,
                bengaluru, // Pickup location
                bengaluru, // Drop location
                ReservationType.DAILY,
                ReservationStatus.SCHEDULED
        );

        Date bookingDate1 = new Date(); // Current date
        Date dateBookedFrom1 = new Date(bookingDate.getTime() + 2 * 24 * 60 * 60 * 1000L); // 2 days later
        Date dateBookedTill1 = new Date(dateBookedFrom.getTime() + 3 * 24 * 60 * 60 * 1000L); // 3 days after dateBookedFrom
        LocalDateTime fromTime1 = LocalDateTime.now().plusDays(6).withHour(9).withMinute(0); // 9 AM, 2 days later
        LocalDateTime toTime1 = fromTime.plusDays(8).withHour(18); // 6 PM, 3 days after fromTime

        // Creating reservation
        Reservation reservation2 = new Reservation(
                101, // Reservation ID, not used since auto-generated
                user1,
                bike1,
                bookingDate1,
                dateBookedFrom1,
                dateBookedTill1,
                bengaluru,
                fromTime1,
                toTime1,
                bengaluru, // Pickup location
                bengaluru, // Drop location
                ReservationType.DAILY,
                ReservationStatus.SCHEDULED
        );
        reservationManager.addReservation(vehicleRentalSystem.getStoreManager().getStoreById("101"), reservation1);
        reservationManager.addReservation(vehicleRentalSystem.getStoreManager().getStoreById("101"), reservation2);

        for(Reservation res : reservationManager.getReservations(vehicleRentalSystem.getStoreManager().getStoreById("101")))
        {
            System.out.println(formatDateTime(res.getFromTime()));
            System.out.println(formatDateTime(res.getToTime()));
            System.out.println("_____________________");
        }
    }
}
