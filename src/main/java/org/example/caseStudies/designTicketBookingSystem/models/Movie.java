package org.example.caseStudies.designTicketBookingSystem.models;

public class Movie {
    private static int idCounter = 101;

    private String id;
    private String name;
    private int duration;

    public Movie(String name, int duration)
    {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
