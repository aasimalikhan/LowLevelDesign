package org.example.designScenarios.designFlightManagement;

import org.example.designScenarios.designFlightManagement.commands.BookFlightCommand;
import org.example.designScenarios.designFlightManagement.exceptions.AirportAlreadyExistsException;
import org.example.designScenarios.designFlightManagement.exceptions.AirportNotFoundException;
import org.example.designScenarios.designFlightManagement.exceptions.UserNotFoundException;
import org.example.designScenarios.designFlightManagement.managers.*;
import org.example.designScenarios.designFlightManagement.models.*;
import org.example.designScenarios.designFlightManagement.utils.Utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class FlightManagementSystem {
    private AirportManager airportManager;
    private FlightManager flightManager;
    private ReservationManager reservationManager;
    private SeatManager seatManager;
    private UserManager userManager;
    private AircraftManager aircraftManager;

    private void initializeAirports()
    {
        try {
            airportManager.addAirport(new Airport("DEL", "Indira Gandhi International Airport", "India"));
            airportManager.addAirport(new Airport("BOM", "Chhatrapati Shivaji International Airport", "India"));
            airportManager.addAirport(new Airport("BLR", "Kempegowda International Airport", "India"));
            airportManager.addAirport(new Airport("HYD", "Rajiv Gandhi International Airport", "India"));
            airportManager.addAirport(new Airport("MAA", "Chennai International Airport",  "India"));
            airportManager.addAirport(new Airport("CCU", "Netaji Subhas Chandra Bose International Airport", "India"));
            airportManager.addAirport(new Airport("COK", "Cochin International Airport", "India"));

            airportManager.addAirport(new Airport("JFK", "John F. Kennedy International Airport",  "USA"));
            airportManager.addAirport(new Airport("LAX", "Los Angeles International Airport", "USA"));
            airportManager.addAirport(new Airport("ORD", "O'Hare International Airport", "USA"));
            airportManager.addAirport(new Airport("DFW", "Dallas/Fort Worth International Airport", "USA"));
            airportManager.addAirport(new Airport("SFO", "San Francisco International Airport", "USA"));
            airportManager.addAirport(new Airport("MIA", "Miami International Airport", "USA"));
            airportManager.addAirport(new Airport("LAS", "Harry Reid International Airport", "USA"));

            airportManager.addAirport(new Airport("LHR", "Heathrow Airport", "UK"));
            airportManager.addAirport(new Airport("CDG", "Charles de Gaulle Airport", "France"));
            airportManager.addAirport(new Airport("FRA", "Frankfurt Airport", "Germany"));
            airportManager.addAirport(new Airport("AMS", "Amsterdam Airport Schiphol", "Netherlands"));
            airportManager.addAirport(new Airport("MAD", "Adolfo Suárez Madrid–Barajas Airport", "Spain"));
            airportManager.addAirport(new Airport("FCO", "Leonardo da Vinci International Airport", "Italy"));
            airportManager.addAirport(new Airport("IST", "Istanbul Airport", "Turkey"));

            airportManager.addAirport(new Airport("DXB", "Dubai International Airport", "UAE"));
            airportManager.addAirport(new Airport("SIN", "Singapore Changi Airport", "Singapore"));
            airportManager.addAirport(new Airport("HKG", "Hong Kong International Airport", "China"));
            airportManager.addAirport(new Airport("PEK", "Beijing Capital International Airport", "China"));
            airportManager.addAirport(new Airport("HND", "Tokyo Haneda Airport", "Japan"));
            airportManager.addAirport(new Airport("ICN", "Incheon International Airport", "South Korea"));
            airportManager.addAirport(new Airport("BKK", "Suvarnabhumi Airport", "Thailand"));

        } catch (AirportAlreadyExistsException e) {
            System.err.println("Error initializing default airports: " + e.getMessage());
        }
    }

    public void bookFlight() {
        try {
            Optional<FlightInstance> flightInstance = flightManager.getFlights("BOM").stream().findFirst();
            if (flightInstance.isEmpty()) {
                System.err.println("Flight does not exist");
                return;
            }

            User user = userManager.getUserById("1000001");
            Passenger passenger1 = new Passenger("Aasim", "Ali", "Khan", "123456789", "aadhar", PassengerType.ADULT);
            Passenger passenger2 = new Passenger("Emaad", "Ali", "Khan", "123456723", "aadhar", PassengerType.ADULT);
            Passenger passenger3 = new Passenger("Rida", "", "Muskaan", "123454389", "aadhar", PassengerType.ADULT);
            Passenger passenger4 = new Passenger("Basith", "Ali", "Khan", "134256789", "aadhar", PassengerType.ADULT);
            Passenger passenger5 = new Passenger("Asif", "Ali", "Khan", "898495845", "aadhar", PassengerType.ADULT);

            List<Seat> availableSeats = seatManager.getAvailableSeats(flightInstance.get());
            System.out.println("AvailableSeatsSize: " + availableSeats.size());

            HashMap<Passenger, Seat> passengerSeatHashMap = new HashMap<>();

            passengerSeatHashMap.put(passenger1, availableSeats.get(0));
            passengerSeatHashMap.put(passenger2, availableSeats.get(1));
            passengerSeatHashMap.put(passenger3, availableSeats.get(2));
            passengerSeatHashMap.put(passenger4, availableSeats.get(3));
            passengerSeatHashMap.put(passenger5, availableSeats.get(4));

            BookFlightCommand bookFlightCommand = new BookFlightCommand(flightInstance.get(), user, passengerSeatHashMap);
            Reservation reservation = bookFlightCommand.execute();
            System.out.println("Flight Booked");
            System.out.println(reservation);
        } catch (Exception e) {
            System.err.println("Error booking flight: " + e.getMessage());
        }
    }

    private void initializeAircraft()
    {
        try {
            String[] companies = {"Airline A", "Airline B", "Airline C"};
            String[] models = {"Boeing 737", "Airbus A320", "Boeing 777", "Airbus A350"};
            Random random = new Random();

            for (int i = 1; i <= 40; i++) {
                Aircraft aircraft = new Aircraft(
                        "REG" + (100000 + i),
                        random.nextBoolean(),
                        companies[random.nextInt(companies.length)],
                        2000 + random.nextInt(24),
                        models[random.nextInt(models.length)]
                );
                seatManager.addSeatsToAircraft(aircraft, random.nextInt(150) + 50);
                aircraftManager.addAircraft(aircraft);
            }
        } catch (Exception e)
        {
            System.err.println("Error initializing default aircraft: " + e.getMessage());
        }
    }

    private void initializeFlightInstances(Flight flight) {
        FlightInstance instance1 = new FlightInstance(LocalDateTime.now().plusDays(1), "G1", FlightStatus.SCHEDULED, flight);
        FlightInstance instance2 = new FlightInstance(LocalDateTime.now().plusDays(3), "G2", FlightStatus.SCHEDULED, flight);
        flight.addFlight(instance1);
        flight.addFlight(instance2);
    }

    private void initializeUsers()
    {
        try {
            Set<String> usedEmails = new HashSet<>();
            Set<String> usedPhoneNumbers = new HashSet<>();

            for (int i = 0; i < 40; i++) {
                LocalDate dob = Utility.generateRandomDOB();
                String email;
                do {
                    email = "user" + (1000 + i) + "@example.com";
                } while (!usedEmails.add(email));

                String phoneNumber;
                do {
                    phoneNumber = Utility.generateRandomPhoneNumber();
                } while (!usedPhoneNumbers.add(phoneNumber));

                User user = new User(dob, email, phoneNumber);
                userManager.addUser(user);
            }
        } catch (UserNotFoundException e) {
            System.err.println("Error initializing default users: " + e.getMessage());
        }
    }


    private void initializeFlights()
    {
        try {
            List<Aircraft> aircrafts = AircraftManager.getInstance().getAllAircraft();
            String[][] routes = {
                    {"DEL", "BOM"}, {"DEL", "HYD"}, {"DEL", "BLR"}, {"DEL", "MAA"},
                    {"BOM", "CCU"}, {"BOM", "HYD"}, {"BOM", "BLR"}, {"BOM", "MAA"},
                    {"BLR", "CCU"}, {"BLR", "HYD"}, {"BLR", "MAA"},
                    {"HYD", "CCU"}, {"HYD", "MAA"},
                    {"CCU", "COK"}, {"COK", "DEL"}, {"COK", "BOM"},
                    {"JFK", "LAX"}, {"JFK", "ORD"}, {"JFK", "SFO"}, {"JFK", "MIA"},
                    {"LAX", "DFW"}, {"LAX", "SFO"}, {"LAX", "LAS"},
                    {"ORD", "DFW"}, {"ORD", "MIA"},
                    {"LHR", "CDG"}, {"LHR", "FRA"}, {"LHR", "AMS"}, {"LHR", "MAD"},
                    {"CDG", "FRA"}, {"CDG", "AMS"}, {"FRA", "MAD"}, {"FRA", "IST"},
                    {"DXB", "SIN"}, {"DXB", "HKG"}
            };
            String[] flightCompanies = {"Indigo", "Virtusa", "Air India", "British Airways", "RyanAir", "Lufthansa"};
            Random random = new Random();

            for (int i = 0; i < 35; i++) {
                String flightCode = "FL" + (1000 + i);
                String origin = routes[i % routes.length][0];
                String destination = routes[i % routes.length][1];
                String company = flightCompanies[(random.nextInt(flightCompanies.length) + 1)%flightCode.length()];
                double distance = random.nextInt(5000) + 100;
                Aircraft aircraft = aircrafts.get(i % aircrafts.size());
                Flight flight = new Flight(flightCode, origin, destination, company, aircraft, distance);
                flightManager.addFlight(flight);
                initializeFlightInstances(flight);
            }
        } catch (Exception e)
        {
            System.err.println("Error initializing default flights: " + e.getMessage());
        }
    }
    private void initialize()
    {
        initializeAirports();
        initializeAircraft();
        initializeFlights();
        initializeUsers();
    }

    public void printFlights() {
        try {
            System.out.println(FlightManager.getInstance().getFlights("BOM"));
        } catch (AirportNotFoundException e)
        {
            System.err.println("Error printing flights: " + e.getMessage());
        }
    }

    public void printAircraft() {
        try {
            System.out.println(AircraftManager.getInstance().getAllAircraft());
        } catch (RuntimeException e) {
            System.err.println("Error printing aircraft: " + e.getMessage());
        }
    }

    public void printAirports() {
        try {
            System.out.println(AirportManager.getInstance().getAirportByCode("BOM"));
        } catch (AirportNotFoundException e) {
            System.err.println("Error printing airports: " + e.getMessage());
        }
    }

    public FlightManagementSystem()
    {
        airportManager = AirportManager.getInstance();
        flightManager = FlightManager.getInstance();
        reservationManager = ReservationManager.getInstance();
        seatManager = SeatManager.getInstance();
        userManager = UserManager.getInstance();
        aircraftManager = AircraftManager.getInstance();
        initialize();
    }


}
