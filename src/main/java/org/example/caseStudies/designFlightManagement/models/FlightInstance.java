package org.example.caseStudies.designFlightManagement.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightInstance {
    private static long idCounter = 1000001;
    private final String id;
    private LocalDateTime departureTime;
    private String gateCode;
    private FlightStatus status;
    private List<String> bookedSeats;
    private Flight flight;

    public FlightInstance(LocalDateTime departureTime, String gateCode, FlightStatus status, Flight flight) {
        this.id = String.valueOf(idCounter++);
        this.departureTime = departureTime;
        this.gateCode = gateCode;
        this.status = status;
        this.bookedSeats = new ArrayList<>();
        this.flight = flight;
    }

    public String getId()
    {
        return id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getGateCode() {
        return gateCode;
    }

    public void setGateCode(String gateCode) {
        this.gateCode = gateCode;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public List<String> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<String> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Flight getFlight()
    {
        return flight;
    }

    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }

    public void bookSeat(String seatId)
    {
        bookedSeats.add(seatId);
    }

    public void unBookSeat(String seatId)
    {
        bookedSeats.remove(seatId);
    }

    @Override
    public String toString() {
        return "FlightInstance{" +
                "id='" + id + '\'' +
                ", departureTime=" + departureTime.toString() +
                ", gateCode='" + gateCode + '\'' +
                ", status=" + status +
                ", bookedSeats=" + bookedSeats +
                ", departureCode= " + flight.getDepartureAirportCode() +
                ", arrivalCode= " + flight.getArrivalAirportCode() +
                '}';
    }

}
