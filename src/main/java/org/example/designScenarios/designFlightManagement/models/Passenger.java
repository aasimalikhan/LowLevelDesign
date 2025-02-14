package org.example.designScenarios.designFlightManagement.models;

import java.time.LocalDate;

public class Passenger extends User{
    private String firstName;
    private String middleName;
    private String lastName;
    private Boolean verified;
    private String uniqueIdentificationNumber;
    private String uniqueIdentificationNumberType;
    private PassengerType type;

    public Passenger(LocalDate dateOfBirth, String email, String phoneNumber) {
        super(dateOfBirth, email, phoneNumber);
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
