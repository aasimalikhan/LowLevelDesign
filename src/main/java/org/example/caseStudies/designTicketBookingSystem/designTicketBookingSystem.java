package org.example.caseStudies.designTicketBookingSystem;

import org.example.caseStudies.designTicketBookingSystem.enums.City;
import org.example.caseStudies.designTicketBookingSystem.enums.SeatCategory;
import org.example.caseStudies.designTicketBookingSystem.managers.MovieManager;
import org.example.caseStudies.designTicketBookingSystem.managers.TheatreManager;
import org.example.caseStudies.designTicketBookingSystem.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class designTicketBookingSystem {
    MovieManager movieManager;
    TheatreManager theatreManager;

    public designTicketBookingSystem() {
        movieManager = new MovieManager();
        theatreManager = new TheatreManager();
    }
    public static void main(String[] args) {
         designTicketBookingSystem app = new designTicketBookingSystem();
         app.initialize();

         app.createBooking(City.HYDERABAD, "AVENGERS");
         app.createBooking(City.HYDERABAD, "AVENGERS");
    }
    private void createBooking(City userCity, String movieName)
    {
        List<Movie> movies= movieManager.getMovies(userCity);
        Movie interestedMovie = null;
        for(Movie movie : movies)
        {
            if(movie.getName().equals(movieName))
            {
                interestedMovie = movie;
            }
        }

        Map<Theatre, List<Show>> showsTheatreWise = theatreManager.getAllShows(interestedMovie, userCity);
        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);


        String seatId = "102";
        List<String> bookedSeats = interestedShow.getBookedSeats();
        if(!bookedSeats.contains(seatId))
        {
            bookedSeats.add(seatId);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats())
            {
                if(screenSeat.getId() == seatId)
                {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeats(myBookedSeats);
            booking.setShow(interestedShow);
        }
        else
        {
            System.out.println("Seat already booked try again");
            return;
        }
        System.out.println("BOOKING SUCCESSFUL");

    }
    private Show createShows(Screen screen, Movie movie, int showStartTime)
    {
        Show show = new Show(movie, screen, showStartTime);
        return show;
    }
    private void createMovies() {
        Movie movie1 = new Movie("AVENGERS", 180);
        Movie movie2 = new Movie("BAHUBALI", 168);
        movieManager.addMovieInCity(movie1, City.HYDERABAD);
        movieManager.addMovieInCity(movie2, City.HYDERABAD);
        movieManager.addMovieInCity(movie1, City.BENGALURU);
        movieManager.addMovieInCity(movie2, City.BENGALURU);
    }
    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createTheatre() {
        Movie avengersEndgame = movieManager.getMovieByName("AVENGERS");
        Movie bahubaliTheBeginning = movieManager.getMovieByName("BAHUBALI");

        Address inoxTheatreAddress = new Address(
                "GVK One Mall, Banjara Hills",
                "Inside GVK One Mall",
                "500034", // Example zip code
                "Telangana",
                "Hyderabad"
        );
        inoxTheatreAddress.setLatitude(17.4260);
        inoxTheatreAddress.setLongitude(78.4460);

        Address pvrTheatreAddress = new Address(
                "Next Galleria Mall, Panjagutta",
                "Inside Next Galleria Mall",
                "500082", // Example zip code
                "Telangana",
                "Hyderabad"
        );
        pvrTheatreAddress.setLatitude(17.4272);
        pvrTheatreAddress.setLongitude(78.4485);

        Theatre inoxTheatre = new Theatre(inoxTheatreAddress);
        inoxTheatre.setScreens(createScreen());
        inoxTheatre.setCity(City.HYDERABAD);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(inoxTheatre.getScreens().get(0), avengersEndgame, 9);
        Show inoxEveningShow = createShows(inoxTheatre.getScreens().get(0), bahubaliTheBeginning, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrTheatre = new Theatre(pvrTheatreAddress);
        pvrTheatre.setScreens(createScreen());
        pvrTheatre.setCity(City.HYDERABAD);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(pvrTheatre.getScreens().get(0), avengersEndgame, 13);
        Show pvrEveningShow = createShows(pvrTheatre.getScreens().get(0), bahubaliTheBeginning, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreManager.addTheatreInCity(inoxTheatre, City.HYDERABAD);
        theatreManager.addTheatreInCity(pvrTheatre, City.HYDERABAD);
    }
    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for(int i = 0; i < 40; i++)
        {
            Seat seat = new Seat();
            seat.setCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        for(int i = 40; i < 70; i++)
        {
            Seat seat = new Seat();
            seat.setCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        for(int i = 70; i < 100; i++)
        {
            Seat seat = new Seat();
            seat.setCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }
    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }
}
