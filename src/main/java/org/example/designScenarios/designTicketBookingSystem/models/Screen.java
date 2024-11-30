package org.example.designScenarios.designTicketBookingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private static int idCounter = 101;

    private String id;
    private List<Seat> seats;

    public Screen()
    {
        this.id = String.valueOf(idCounter++);
        seats = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void addSeat(Seat seat)
    {
        seats.add(seat);
    }
    public void deleteSeat(Seat seat)
    {
        seats.remove(seat);
    }

    public List<Seat> getSeats()
    {
        return seats;
    }
}
