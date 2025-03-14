package org.example.caseStudies.designVehicleRentalManagementSystem.models;

import java.util.Date;

public class Car extends Vehicle{
    public Car(String vehicleNumber, VehicleType vehicleType, String vehicleCompanyName, String vehicleModel, int distanceDriven, Date manufacturingDate, int dailyRentalCost, int hourlyRentalCost, VehicleStatus vehicleStatus) {
        super(vehicleNumber, vehicleType, vehicleCompanyName, vehicleModel, distanceDriven, manufacturingDate, dailyRentalCost, hourlyRentalCost, vehicleStatus);
    }
}
