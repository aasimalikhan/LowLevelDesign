package org.example.caseStudies.designFlightManagement.managers;

import org.example.caseStudies.designFlightManagement.exceptions.SeatNotAvailableException;
import org.example.caseStudies.designFlightManagement.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class SeatManager {
    private static SeatManager seatManager;

    private SeatManager() {}

    public static SeatManager getInstance()
    {
        if(seatManager == null)
        {
            synchronized (SeatManager.class)
            {
                seatManager = new SeatManager();
            }
        }
        return seatManager;
    }

    public void addSeatsToAircraft(Aircraft aircraft, int seatCount)
    {
        List<Seat> seats = new ArrayList<>();
        Random random = new Random();
        SeatType[] seatTypes = SeatType.values();
        SeatClass[] seatClasses = SeatClass.values();

        for (int i = 0; i < seatCount; i++) {
            Seat seat = new Seat(
                    "AAP",
                    seatTypes[random.nextInt(seatTypes.length)],
                    seatClasses[random.nextInt(seatClasses.length)]
            );
            seats.add(seat);
        }
        aircraft.setSeatLayout(seats);
    }

    public List<Seat> getAvailableSeats(FlightInstance flightInstance)
    {
        Aircraft aircraft = flightInstance.getFlight().getAircraft();
        List<Seat> seatLayout = aircraft.getSeatLayout();
        List<String> bookedSeats = flightInstance.getBookedSeats();
        return seatLayout.stream().filter((seat) -> !bookedSeats.contains(seat.getId())).toList();
    }

    public boolean isSeatAvailable(FlightInstance flightInstance, String seatId)
    {
        Optional<Seat> seat = getAvailableSeats(flightInstance).stream().filter((seatInstance) -> seatInstance.getId().equals(seatId)).findFirst();
        return seat.isPresent();
    }

    public boolean isGroupSeatAvailable(FlightInstance flightInstance, List<Seat> seats) throws SeatNotAvailableException {
        long seatCount = seats.size();
        List<String> unavailableSeats = new ArrayList<>();
        long seatAvailableCount = seats.stream().filter((seat) -> {
            boolean currentSeatAvailable = isSeatAvailable(flightInstance, seat.getId());
            if(!currentSeatAvailable)
            {
                unavailableSeats.add("Seat with id: " + seat.getId() + " not available");
            }
            return currentSeatAvailable;
        }).count();
        if (seatCount != seatAvailableCount)
        {
            System.out.println(unavailableSeats);
            throw new SeatNotAvailableException(unavailableSeats.toString());
        }
        return true;
    }
}
