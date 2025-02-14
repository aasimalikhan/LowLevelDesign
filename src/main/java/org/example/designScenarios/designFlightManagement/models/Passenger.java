package org.example.designScenarios.designFlightManagement.models;

import java.time.LocalDate;

public class Passenger {
    private static long idCounter = 1000001;
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Boolean verified;
    private String uniqueIdentificationNumber;
    private String uniqueIdentificationNumberType;
    private PassengerType type;

    public Passenger(String firstName, String middleName, String lastName, String uniqueIdentificationNumber, String uniqueIdentificationNumberType, PassengerType type) {
        this.id = String.valueOf(idCounter++);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName  = middleName;
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
        this.uniqueIdentificationNumberType = uniqueIdentificationNumberType;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getUniqueIdentificationNumber() {
        return uniqueIdentificationNumber;
    }

    public void setUniqueIdentificationNumber(String uniqueIdentificationNumber) {
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    }

    public String getUniqueIdentificationNumberType() {
        return uniqueIdentificationNumberType;
    }

    public void setUniqueIdentificationNumberType(String uniqueIdentificationNumberType) {
        this.uniqueIdentificationNumberType = uniqueIdentificationNumberType;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }
}
