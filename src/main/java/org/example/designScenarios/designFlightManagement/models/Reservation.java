package org.example.designScenarios.designFlightManagement.models;

import java.time.LocalDateTime;
import java.util.Map;

public class Reservation {
    private static long idCounter = 100001;
    private final String id;
    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, Seat> passengerSeatMap;
    private Payment payment;
    private User initiator;
    private final LocalDateTime creationDate;

    public Reservation(String reservationNumber, Map<Passenger, Seat> passengerSeatMap, Payment payment, User initiator, LocalDateTime creationDate) {
        this.id = String.valueOf(idCounter++);
        this.reservationNumber = reservationNumber;
        this.passengerSeatMap = passengerSeatMap;
        this.payment = payment;
        this.initiator = initiator;
        this.creationDate = creationDate;
    }

    public String getId()
    {
        return id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public FlightInstance getFlight()
    {
        return flight;
    }

    public void setFlight(FlightInstance flight) {
        this.flight = flight;
    }

    public Map<Passenger, Seat> getPassengerSeatMap() {
        return passengerSeatMap;
    }

    public void setPassengerSeatMap(Map<Passenger, Seat> passengerSeatMap) {
        this.passengerSeatMap = passengerSeatMap;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getInitiator() { return initiator; }

    public void setInitiator(User initiator) { this.initiator = initiator; }

    public LocalDateTime getCreationDate() { return creationDate; }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", reservationNumber='" + reservationNumber + '\'' +
                ", flight=" + flight.getId() +
                ", payment=" + payment.getAmount() +
                ", initiator=" + initiator.getId() +
                ", creationDate=" + creationDate +
                '}';
    }
}
