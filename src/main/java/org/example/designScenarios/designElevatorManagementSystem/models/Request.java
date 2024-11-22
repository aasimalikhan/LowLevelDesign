package org.example.designScenarios.designElevatorManagementSystem.models;

public class Request {
    private final int sourceFloor;

    public Request(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }
    public int getSourceFloor() {
        return sourceFloor;
    }
}
