package org.example.designScenarios.designFlightManagement.models;

import java.time.LocalDate;

public class User {
    private static long idCounter = 1000001;
    private final String id;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;

    public User(LocalDate dateOfBirth, String email, String phoneNumber) {
        this.id = String.valueOf(idCounter++);
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId()
    {
        return id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
