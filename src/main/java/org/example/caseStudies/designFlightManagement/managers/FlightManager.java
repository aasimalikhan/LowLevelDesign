package org.example.caseStudies.designFlightManagement.managers;

import org.example.caseStudies.designFlightManagement.exceptions.AirportNotFoundException;
import org.example.caseStudies.designFlightManagement.exceptions.FlightNotFoundException;
import org.example.caseStudies.designFlightManagement.models.Airport;
import org.example.caseStudies.designFlightManagement.models.Flight;
import org.example.caseStudies.designFlightManagement.models.FlightInstance;
import org.example.caseStudies.designFlightManagement.models.FlightStatus;
import org.example.caseStudies.designFlightManagement.utils.FlightSearch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class FlightManager {
    private final Map<Airport, List<Flight>> airportFlightMap;

    private static FlightManager flightManager;

    public FlightManager()
    {
        airportFlightMap = new HashMap<>();
    }

    public static FlightManager getInstance()
    {
        if(flightManager == null)
        {
            synchronized (FlightManager.class)
            {
                flightManager = new FlightManager();
            }
        }
        return flightManager;
    }

    public void addFlight(Flight flight) throws AirportNotFoundException {
        Airport airport = AirportManager.getInstance().getAirportByCode(flight.getDepartureAirportCode());
        if(!airportFlightMap.containsKey(airport))
        {
            airportFlightMap.put(airport, new ArrayList<>());
        }
        airportFlightMap.get(airport).add(flight);
    }

    public void removeFlight(Flight flight) throws AirportNotFoundException {
        Airport airport = AirportManager.getInstance().getAirportByCode(flight.getDepartureAirportCode());
        airportFlightMap.get(airport).remove(flight);
    }

    public void validateFlight(FlightInstance flightInstance) throws AirportNotFoundException, FlightNotFoundException {
        List<FlightInstance> flights = getScheduledFlights(flightInstance.getDepartureTime().toLocalDate(), flightInstance.getFlight().getArrivalAirportCode());
        Optional<FlightInstance> flightFound = flights.stream().filter((flight) -> flight.getDepartureTime().isAfter(LocalDateTime.now()) && flight.getStatus().equals(FlightStatus.SCHEDULED)).findFirst();
        if(flightFound.isEmpty())
        {
            throw new FlightNotFoundException("Flight not found");
        }
    }

    public List<FlightInstance> getFlights(String airportCode) throws AirportNotFoundException {
        Airport airport = AirportManager.getInstance().getAirportByCode(airportCode);
        List<Flight> airportFlights = airportFlightMap.get(airport);

        return airportFlights.stream().flatMap((flight) -> flight.getFlightInstances().stream()).filter((flight) ->
            flight.getDepartureTime().toLocalDate().isAfter(LocalDate.now())).toList();
    }

    public List<FlightInstance> getScheduledFlights(String airportCode) throws AirportNotFoundException {
        return getFlights(airportCode).stream().filter((flight) -> flight.getStatus().equals(FlightStatus.SCHEDULED)).toList();
    }

    public List<FlightInstance> getScheduledFlights(LocalDate date, String airportCode) throws AirportNotFoundException {
        Airport airport = AirportManager.getInstance().getAirportByCode(airportCode);
        List<Flight> airportFlights = airportFlightMap.get(airport);

        return airportFlights.stream().flatMap((flight) -> flight.getFlightInstances().stream()).filter((flight) ->
                flight.getDepartureTime().toLocalDate().equals(date)).toList();
    }

    public List<FlightInstance> getDelayedFlights(String airportCode) throws AirportNotFoundException {
        return getFlights(airportCode).stream().filter((flight) -> flight.getStatus().equals(FlightStatus.DELAYED)).toList();
    }

    public List<FlightInstance> getCancelledFlights(String airportCode) throws AirportNotFoundException {
        return getFlights(airportCode).stream().filter((flight) -> flight.getStatus().equals(FlightStatus.CANCELLED)).toList();
    }

    public List<FlightInstance> getFlights(LocalDate date, FlightSearch searchRequest) throws AirportNotFoundException {
        Airport departureAirport = AirportManager.getInstance().getAirportByCode(searchRequest.arrivalAirportCode);
        List<Flight> flightSearch = airportFlightMap.get(departureAirport).stream().filter((flight) -> flight.getArrivalAirportCode().equals(searchRequest.arrivalAirportCode) && flight.getDepartureAirportCode().equals(searchRequest.departureAirportCode)).toList();
        return flightSearch.stream().flatMap((flight) -> flight.getFlightInstances().stream()).filter((flight) -> flight.getDepartureTime().toLocalDate().equals(date)).toList();
    }
}
