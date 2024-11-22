package org.example.designScenarios.designVehicleRentalManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static int counter = 101;

    String id;
    VehicleInventory inventory;
    Location location;
    List<Reservation> reservationList;

    public Store(Location location) {
        this.id = String.valueOf(counter++);
        this.inventory = new VehicleInventory();
        this.location = location;
        this.reservationList = new ArrayList<>();
    }

    public VehicleInventory getInventory() {
        return inventory;
    }

    public void setInventory(VehicleInventory inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public String getId() {
        return id;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", location=" + location +
                '}';
    }
}
