package org.example.designScenarios.designTicketBookingSystem.managers;

import org.example.designScenarios.designTicketBookingSystem.enums.City;
import org.example.designScenarios.designTicketBookingSystem.models.Movie;
import org.example.designScenarios.designTicketBookingSystem.models.Show;
import org.example.designScenarios.designTicketBookingSystem.models.Theatre;

import java.util.*;

public class TheatreManager {
    private Map<City, List<Theatre>> cityTheatreMap;
    List<Theatre> allTheatres;

    public TheatreManager()
    {
        this.cityTheatreMap = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatreInCity(Theatre theatre, City city)
    {
        List<Theatre> theatresInCity = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        theatresInCity.add(theatre);
        cityTheatreMap.put(city, theatresInCity);
        allTheatres.add(theatre);
    }

    public void removeTheatreInCity(Theatre theatre, City city)
    {
        if (cityTheatreMap.containsKey(city)) {
            cityTheatreMap.get(city).remove(theatre);
        }
    }
    public void removeTheatre(Theatre theatre)
    {
        for(Map.Entry<City, List<Theatre>> entry : cityTheatreMap.entrySet())
        {
            removeTheatreInCity(theatre, entry.getKey());
        }
        allTheatres.remove(theatre);
    }

    public List<Theatre> getTheatres(City city)
    {
        return cityTheatreMap.getOrDefault(city, new ArrayList<>());
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, City city)
    {
        Map<Theatre, List<Show>> theatreShowMap = new HashMap<>();
        List<Theatre> theatres = getTheatres(city);
        for(Theatre theatre : theatres)
        {
            List<Show> movieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for(Show show : shows)
            {
                if(show.getMovie().getId() == movie.getId())
                {
                    movieShows.add(show);
                }
            }
            if(!movieShows.isEmpty())
            {
                theatreShowMap.put(theatre, movieShows);
            }
        }

        return theatreShowMap;
    }
}
