package org.example.designScenarios.designElevatorManagementSystem.models;

public class Floor {
    private long id;
    private int floorNumber;
    private FloorButtons floorButtons;

    public Floor(long id, int floorNumber) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.floorButtons = new FloorButtons(this); // Pass 'this' to establish the relationship
    }

    public long getId() {
        return id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public FloorButtons getFloorButtons() {
        return floorButtons;
    }
}
