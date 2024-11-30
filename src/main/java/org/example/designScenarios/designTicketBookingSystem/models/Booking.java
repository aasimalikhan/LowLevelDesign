package org.example.designScenarios.designTicketBookingSystem.models;

import org.example.designScenarios.designTicketBookingSystem.enums.BookingStatus;

import java.util.List;

public class Booking {
    private int idCounter = 101;

    private String id;
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;

    public Booking()
    {
        this.id = String.valueOf(idCounter++);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
