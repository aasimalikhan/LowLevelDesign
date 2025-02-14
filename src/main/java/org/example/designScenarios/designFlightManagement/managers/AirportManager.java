package org.example.designScenarios.designFlightManagement.managers;

import org.example.designScenarios.designFlightManagement.exceptions.AirportAlreadyExistsException;
import org.example.designScenarios.designFlightManagement.exceptions.AirportNotFoundException;
import org.example.designScenarios.designFlightManagement.models.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportManager {
    private final List<Airport> allAirports;
    public static AirportManager airportManager;

    private AirportManager()
    {
        allAirports = new ArrayList<>();
    }

    public static AirportManager getInstance()
    {
        if(airportManager == null)
        {
            synchronized (AirportManager.class)
            {
                airportManager = new AirportManager();
            }
        }
        return airportManager;
    }

    public Airport getAirportById(String airportId) throws AirportNotFoundException {
        return allAirports.stream().filter((airport) -> airport.getId().equals(airportId)).findFirst().orElseThrow(() -> new AirportNotFoundException("Airport with id: " + airportId + " not found"));
    }

    public Airport getAirportByCode(String airportCode) throws AirportNotFoundException {
        return allAirports.stream().filter((airport) -> {
            return airport.getCode().equals(airportCode);
        }).findFirst().orElseThrow(() -> new AirportNotFoundException("Airport with code: " + airportCode + " not found"));
    }

    public void addAirport(Airport airport) throws AirportAlreadyExistsException {
        boolean airportExistsById = allAirports.stream().anyMatch(existingAirport -> existingAirport.getId().equals(airport.getId()));

        if(airportExistsById)
        {
            throw new AirportAlreadyExistsException("Airport with id: " + airport.getId() + " already exists!");
        }
        boolean airportExistsByCode = allAirports.stream().anyMatch(existingAirport -> existingAirport.getCode().equals(airport.getCode()));

        if(airportExistsByCode)
        {
            throw new AirportAlreadyExistsException("Airport with code: " + airport.getCode() + " already exists!");
        }
        allAirports.add(airport);
    }

    public void removeAirport(String airportId) throws AirportNotFoundException {
        Airport airport = getAirportById(airportId);
        allAirports.remove(airport);
    }

    public void displayAllAirports()
    {
        for(Airport airport : allAirports)
        {
            System.out.println(airport);
        }
    }
}
