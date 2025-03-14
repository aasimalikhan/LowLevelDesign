package org.example.caseStudies.designVehicleRentalManagementSystem.models;

import org.example.caseStudies.designVehicleRentalManagementSystem.exception.ReservationNotFoundException;
import org.example.caseStudies.designVehicleRentalManagementSystem.exception.VehicleNotAvailableException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationManager {
    private StoreManager storeManager;

    public StoreManager getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    private boolean isReservationOverlapping(LocalDateTime fromTime1, LocalDateTime toTime1, LocalDateTime fromTime2, LocalDateTime toTime2) {
        return fromTime1.isBefore(toTime2) && toTime1.isAfter(fromTime2);
    }

    private boolean isVehicleAvailable(Store store, Reservation reservation)
    {
        Vehicle vehicle = store.getInventory().getVehicleById(reservation.getVehicle().getId());
        if(vehicle == null)
        {
            return false;
        }
        List<Reservation> storeReservations = getReservations(store);
        for(Reservation existingReservation : storeReservations)
        {
            if(existingReservation.getVehicle().equals(reservation.getVehicle()))
            {
                if(isReservationOverlapping(existingReservation.getFromTime(), existingReservation.getToTime(), reservation.getFromTime(), reservation.getToTime()))
                {
                    return false;
                }
            }
        }
        if(vehicle.getVehicleStatus() == VehicleStatus.ACTIVE) {
            return true;
        }
        return false;
    }

    public void addReservation(Store store, Reservation reservation)
    {
        if(isVehicleAvailable(store, reservation))
        {
            System.out.println("Reservation done bruhhh");
            store.getReservationList().add(reservation);
        }
        else
        {
            System.out.println("Reservation failed");
            throw new VehicleNotAvailableException("Vehicle not available for reservation");
        }
    }
    public void updateReservation(Store store, String reservationId, Reservation updatedReservation)
    {
        Optional<Reservation> reservationToUpdate = store.getReservationList().stream().filter(item -> item.getReservationId().equals(reservationId)).findFirst();
        if (reservationToUpdate.isPresent()) {
            Reservation reservation = reservationToUpdate.get();

            // Update each field that can be updated
            if (updatedReservation.getVehicle() != null) {
                reservation.setVehicle(updatedReservation.getVehicle());
            }

            if (updatedReservation.getLocation() != null) {
                reservation.setLocation(updatedReservation.getLocation());
            }

            if (updatedReservation.getReservationType() != null) {
                reservation.setReservationType(updatedReservation.getReservationType());
            }

            if (updatedReservation.getReservationStatus() != null) {
                reservation.setReservationStatus(updatedReservation.getReservationStatus());
            }
        } else {
            throw new ReservationNotFoundException("Reservation with ID " + reservationId + " not found.");
        }
    }

    public boolean deleteReservation(Store store, Reservation reservation)
    {
        Optional<Reservation> reservationToDelete = store.getReservationList().stream().filter(item -> item.getReservationId().equals(reservation.getReservationId())).findFirst();
        if (reservationToDelete.isPresent())
        {
            Reservation reservationObj = reservationToDelete.get();
            store.getReservationList().remove(reservationObj);
            System.out.println("Reservation : " + reservationObj.getReservationId() + " deleted successfully");
            return true;
        }
        else {
            throw new ReservationNotFoundException("Reservation with ID " + reservation.getReservationId() + " not found.");
        }
    }

    public List<Reservation> getReservations(Store store)
    {
        return store.getReservationList();
    }

    public List<Reservation> getAllReservations(StoreManager storeManager)
    {
        List<Store> stores = storeManager.getAllStores();
        List<Reservation> allReservations = new ArrayList<>();
        for (Store store : stores) {
            allReservations.addAll(store.getReservationList()); // Assuming `getReservationList()` returns a List<Reservation>
        }

        return allReservations;
    }

}
