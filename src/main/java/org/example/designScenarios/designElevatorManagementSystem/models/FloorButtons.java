package org.example.designScenarios.designElevatorManagementSystem.models;

public class FloorButtons {
    Floor floor;
    ElevatorSystem elevatorSystem;
    public FloorButtons(Floor floor)
    {
        this.floor = floor;
    }
    public void pressUpButton() throws InterruptedException {
        elevatorSystem.processElevatorRequest(Direction.UP, floor);
    }
    public void pressDownButton() throws InterruptedException {
        elevatorSystem.processElevatorRequest(Direction.DOWN, floor);
    }

    public void setElevatorSystem(ElevatorSystem elevatorSystem) {
        this.elevatorSystem = elevatorSystem;
    }
}
