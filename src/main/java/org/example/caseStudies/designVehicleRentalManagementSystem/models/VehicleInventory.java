package org.example.caseStudies.designVehicleRentalManagementSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleInventory {
    List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public boolean deleteVehicle(String vehicleId) {
        Optional<Vehicle> vehicleToDelete = vehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(vehicleId))
                .findFirst();

        if (vehicleToDelete.isPresent()) {
            vehicles.remove(vehicleToDelete.get());
            return true;
        } else {
            return false;
        }
    }

    public boolean updateVehicle(String vehicleId, Vehicle updatedVehicle) {
        Optional<Vehicle> vehicleToUpdate = vehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(vehicleId))
                .findFirst();

        if (vehicleToUpdate.isPresent()) {
            Vehicle vehicle = vehicleToUpdate.get();
            vehicle.setVehicleStatus(updatedVehicle.getVehicleStatus());
            return true;
        } else {
            return false;
        }
    }

    public Vehicle getVehicleById(String vehicleId) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(vehicleId))
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }
}