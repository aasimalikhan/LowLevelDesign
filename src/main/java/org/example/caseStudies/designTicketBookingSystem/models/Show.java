package org.example.caseStudies.designTicketBookingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private static int idCounter = 101;

    private String id;
    private Movie movie;
    private Screen screen;
    int startTime;
    List<String> bookedSeats;

    public Show(Movie movie, Screen screen, int startTime)
    {
        this.id = String.valueOf(idCounter++);
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeats = new ArrayList<>();
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public List<String> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<String> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public void addSeatBooking(String id)
    {
        bookedSeats.add(id);
    }
    public void removeSeatBooking(String id)
    {
        bookedSeats.remove(id);
    }
}
