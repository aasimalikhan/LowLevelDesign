package org.example.designScenarios.designVehicleRentalManagementSystem.models;

import java.util.Date;

public class Bike extends Vehicle{
    public Bike(String vehicleNumber, VehicleType vehicleType, String vehicleCompanyName, String vehicleModel, int distanceDriven, Date manufacturingDate, int dailyRentalCost, int hourlyRentalCost, VehicleStatus vehicleStatus) {
        super(vehicleNumber, vehicleType, vehicleCompanyName, vehicleModel, distanceDriven, manufacturingDate, dailyRentalCost, hourlyRentalCost, vehicleStatus);
    }
}
