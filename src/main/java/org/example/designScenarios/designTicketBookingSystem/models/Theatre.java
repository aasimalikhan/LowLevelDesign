package org.example.designScenarios.designTicketBookingSystem.models;

import org.example.designScenarios.designTicketBookingSystem.enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private static int idCounter;
    private String id;
    private Address address;
    private List<Screen> screens;
    private List<Show> shows;
    private City city;

    public Theatre(Address address)
    {
        this.id = String.valueOf(idCounter++);
        this.address = address;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public void addScreen(Screen screen)
    {
        this.screens.add(screen);
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public void removeScreen(Screen screen)
    {
        this.screens.remove(screen);
    }

    public void addShow(Show show)
    {
        this.shows.add(show);
    }
    public void removeShow(Show show)
    {
        this.shows.remove(show);
    }
}
