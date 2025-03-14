package org.example.caseStudies.designElevatorManagementSystem.models;

import java.time.LocalDateTime;

public abstract class ElevatorRequest {
    private int toFloor;
    private final LocalDateTime requestTime;

    public ElevatorRequest(int toFloor)
    {
        this.requestTime = LocalDateTime.now();
    }

    public abstract RequestType getRequestType();

    public int getToFloor() {
        return toFloor;
    }

    public void setToFloor(int toFloor) {
        this.toFloor = toFloor;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }
}
