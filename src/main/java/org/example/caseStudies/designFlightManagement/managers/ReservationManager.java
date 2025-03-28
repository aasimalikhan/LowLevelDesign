package org.example.caseStudies.designFlightManagement.managers;

import org.example.caseStudies.designFlightManagement.exceptions.UserNotFoundException;
import org.example.caseStudies.designFlightManagement.models.Passenger;
import org.example.caseStudies.designFlightManagement.models.Payment;
import org.example.caseStudies.designFlightManagement.models.Reservation;
import org.example.caseStudies.designFlightManagement.models.User;
import org.example.caseStudies.designVehicleRentalManagementSystem.exception.ReservationNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationManager {
    private Map<User, List<Reservation>> userReservationMap;

    public static ReservationManager reservationManager = null;

    private ReservationManager()
    {
        userReservationMap = new HashMap<>();
    }

    public static ReservationManager getInstance()
    {
        if(reservationManager == null)
        {
            synchronized (ReservationManager.class)
            {
                reservationManager = new ReservationManager();
            }
        }
        return reservationManager;
    }

    public List<Reservation> getUserReservations(String userId) throws UserNotFoundException {
        Passenger user = UserManager.getInstance().getPassengerById(userId);
        return userReservationMap.get(user);
    }

    public List<Reservation> getAllReservations()
    {
        return userReservationMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public Payment getPaymentDetailsForReservation(String reservationId)
    {
        return getAllReservations().stream().filter((reservation) -> reservation.getId().equals(reservationId)).findFirst().orElseThrow(() -> new ReservationNotFoundException("Reservation with id: " + reservationId + " not found!")).getPayment();
    }

    public List<Reservation> getUpcomingReservationsForUser(String userId) throws UserNotFoundException {
        User user = UserManager.getInstance().getUserById(userId);
        List<Reservation> userReservations = userReservationMap.get(user);
        return userReservations.stream().filter((reservation) -> reservation.getFlight().getDepartureTime().isAfter(LocalDateTime.now())).toList();
    }

    public List<Reservation> getCompletedReservationsForUser(String userId) throws UserNotFoundException {
        Passenger user = UserManager.getInstance().getPassengerById(userId);
        List<Reservation> userReservations = userReservationMap.get(user);
        return userReservations.stream().filter((reservation) -> reservation.getFlight().getDepartureTime().isBefore(LocalDateTime.now())).toList();
    }

    public Reservation addReservation(Reservation reservation)
    {
        if(!userReservationMap.containsKey(reservation.getInitiator()))
        {
            userReservationMap.put(reservation.getInitiator(), new ArrayList<>());
        }
        userReservationMap.get(reservation.getInitiator()).add(reservation);
        return reservation;
    }
}
