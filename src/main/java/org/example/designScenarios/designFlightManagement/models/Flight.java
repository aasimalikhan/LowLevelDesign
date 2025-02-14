package org.example.designScenarios.designFlightManagement.models;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private static long idCounter = 100001;
    private String id;
    private String code;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private String company;
    private double distance;
    private Aircraft aircraft;
    private List<FlightInstance> flights;

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", arrivalAirportCode='" + arrivalAirportCode + '\'' +
                ", company='" + company + '\'' +
                ", distance=" + distance +
                ", aircraft=" + aircraft +
                ", flights=" + flights +
                '}';
    }

    public Flight(String code, String departureAirportCode, String arrivalAirportCode, String company, Aircraft aircraft, double distance) {
        this.id = String.valueOf(idCounter++);
        this.code = code;
        this.departureAirportCode = departureAirportCode;
        this.arrivalAirportCode = arrivalAirportCode;
        this.company = company;
        this.aircraft = aircraft;
        this.flights = new ArrayList<>();
        this.distance = distance;
    }

    public String getId()
    {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getDistance() { return distance; }

    public void setDistance(double distance) { this.distance = distance; }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public List<FlightInstance> getFlightInstances()
    {
        return flights;
    }

    public void addFlight(FlightInstance flightInstance)
    {
        flights.add(flightInstance);
    }

    public void removeFlight(String flightId)
    {
        this.flights = flights.stream().filter((flight) -> { return !flight.getId().equals(flightId); }).toList();
    }
}
