package org.example.designScenarios.designParkingLot;

import org.example.designScenarios.designParkingLot.exceptions.ParkingSpotLimitReachedException;
import org.example.designScenarios.designParkingLot.exceptions.ParkingSpotNotFoundException;
import org.example.designScenarios.designParkingLot.factory.ParkingManagerFactory;
import org.example.designScenarios.designParkingLot.managers.ParkingSpotManager;
import org.example.designScenarios.designParkingLot.managers.TwoWheelerParkingSpotManager;
import org.example.designScenarios.designParkingLot.models.*;
import org.example.designScenarios.designParkingLot.strategy.parking.DefaultParkingStrategy;
import org.example.designScenarios.designParkingLot.strategy.pricing.HourBasedPricingStrategy;
import org.example.designScenarios.designParkingLot.utils.VehicleNumberGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        EntranceGate entranceGate = new EntranceGate();
        List<Ticket> tickets = new ArrayList<>();
        ParkingSpotManager twoWheelerManager = ParkingManagerFactory.getParkingSpotManager(VehicleType.TWOWHEELER);
        for(int i = 0; i < 100; i++)
        {
            twoWheelerManager.addParkingSpace();
        }
        System.out.println("Empty two wheeler 2 wheeler parking spaces available: " + twoWheelerManager.getEmptySpaces());
        for(int i = 0; i < 60; i++)
        {
            ParkingSpot spot = entranceGate.findParkingSpot(VehicleType.TWOWHEELER);
            Vehicle vehicle = new Vehicle(VehicleNumberGenerator.generateVehicleNumber(), VehicleType.TWOWHEELER);
            entranceGate.reserveSpot(vehicle, spot);
            Ticket ticket = entranceGate.generateTicket(spot);
            tickets.add(ticket);
        }
        Thread.sleep(1000);
        System.out.println("Empty two wheeler 2 wheeler parking spaces available: " + twoWheelerManager.getEmptySpaces());
        ExitGate exitGate = new ExitGate();
        exitGate.setPricingStrategy(new HourBasedPricingStrategy());

        for(int i = 0; i < tickets.size(); i++)
        {
            Ticket ticket = tickets.get(i);
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime twoHoursBefore = currentDateTime.minusHours(new Random().nextInt(100));
            ticket.setEntryTime(twoHoursBefore);
            double price = exitGate.calculatePrice(ticket);

            System.out.println(ticket);
            System.out.println("price: " + price);
            System.out.println("");
            exitGate.unparkVehicle(ticket);
        }
    }
}
