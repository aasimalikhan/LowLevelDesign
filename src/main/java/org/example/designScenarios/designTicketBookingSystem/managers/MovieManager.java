package org.example.designScenarios.designTicketBookingSystem.managers;

import org.example.designScenarios.designTicketBookingSystem.enums.City;
import org.example.designScenarios.designTicketBookingSystem.models.Movie;

import java.util.*;

public class MovieManager {
    private Map<City, List<Movie>>  cityMovieMap;
    private List<Movie> allMovies;

    public MovieManager()
    {
        this.cityMovieMap = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }
    public void addMovieInCity(Movie movie, City city)
    {
        List<Movie> moviesInCity = cityMovieMap.getOrDefault(city, new ArrayList<>());
        moviesInCity.add(movie);
        cityMovieMap.put(city, moviesInCity);
        allMovies.add(movie);
    }
    public void removeMovieInCity(Movie movie, City city)
    {
        if(cityMovieMap.containsKey(city)) {
            cityMovieMap.get(city).remove(movie);
        }
    }
    public void removeMovie(Movie movie)
    {
        for(Map.Entry<City, List<Movie>> entry : cityMovieMap.entrySet())
        {
            removeMovieInCity(movie, entry.getKey());
        }
        allMovies.remove(movie);
    }
    public List<Movie> getMovies(City city)
    {
        if(cityMovieMap.containsKey(city))
        {
            return cityMovieMap.get(city);
        }
        return Collections.emptyList();
    }
    public Movie getMovieByName(String movieName) {

        for(Movie movie : allMovies) {
            if((movie.getName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

}
