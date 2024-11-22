package org.example.designScenarios.designVehicleRentalManagementSystem.models;

import java.util.Date;

public class Vehicle {
    private static int counter = 101; // Static counter for unique IDs

    private String id;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String vehicleCompanyName;
    private String vehicleModel;
    private int distanceDriven;
    private Date manufacturingDate;
    private int dailyRentalCost;
    private int hourlyRentalCost;
    private VehicleStatus vehicleStatus;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, String vehicleCompanyName,
                   String vehicleModel, int distanceDriven, Date manufacturingDate,
                   int dailyRentalCost, int hourlyRentalCost, VehicleStatus vehicleStatus) {
        this.id = String.valueOf(counter++); // Generate unique ID
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleCompanyName = vehicleCompanyName;
        this.vehicleModel = vehicleModel;
        this.distanceDriven = distanceDriven;
        this.manufacturingDate = manufacturingDate;
        this.dailyRentalCost = dailyRentalCost;
        this.hourlyRentalCost = hourlyRentalCost;
        this.vehicleStatus = vehicleStatus;
    }

    public String getId() {
        return id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleCompanyName() {
        return vehicleCompanyName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public int getDailyRentalCost() {
        return dailyRentalCost;
    }

    public int getHourlyRentalCost() {
        return hourlyRentalCost;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", vehicleCompanyName='" + vehicleCompanyName + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", distanceDriven=" + distanceDriven +
                ", manufacturingDate=" + manufacturingDate +
                ", dailyRentalCost=" + dailyRentalCost +
                ", hourlyRentalCost=" + hourlyRentalCost +
                ", vehicleStatus=" + vehicleStatus +
                '}';
    }
}
