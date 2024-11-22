package org.example.designScenarios.designVehicleRentalManagementSystem.models;

public class User {
    private static int counter = 101;

    String userId;
    String username;
    String drivingLicense;

    public User(String username, String drivingLicense) {
        this.userId = String.valueOf(counter++);
        this.username = username;
        this.drivingLicense = drivingLicense;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}
