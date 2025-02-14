package org.example.designScenarios.designFlightManagement.models;

import java.util.List;

public class Aircraft {
    private static long idCounter = 100001;
    private String id;
    private String registrationNumber;
    private Boolean isDomestic;
    private String company;
    private int manufactureYear;
    private String modelName;
    private List<Seat> seatLayout;

    @Override
    public String toString() {
        return "Aircraft{" +
                "id='" + id + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", isDomestic=" + isDomestic +
                ", company='" + company + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", modelName='" + modelName + '\'' +
                ", seatLayout=" + seatLayout +
                '}';
    }

    public Aircraft(String registrationNumber, Boolean isDomestic, String company, int manufactureYear, String modelName) {
        this.id = String.valueOf(idCounter++);
        this.registrationNumber = registrationNumber;
        this.isDomestic = isDomestic;
        this.company = company;
        this.manufactureYear = manufactureYear;
        this.modelName = modelName;
    }

    public String getId()
    {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Boolean getDomestic() {
        return isDomestic;
    }

    public void setDomestic(Boolean domestic) {
        isDomestic = domestic;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getModelName() {
        return modelName;
    }

    public List<Seat> getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(List<Seat> seatLayout) {
        this.seatLayout = seatLayout;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
