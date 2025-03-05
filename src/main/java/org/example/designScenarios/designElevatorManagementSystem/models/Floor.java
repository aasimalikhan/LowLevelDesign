package org.example.designScenarios.designElevatorManagementSystem.models;

public class Floor {
    private final int floorNumber;

    public Floor(int floorNumber)
    {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber()
    {
        return floorNumber;
    }

    public void update(Elevator elevator)
    {
        System.out.println("Elevator :" + elevator.getElevatorId() + " has reached floor: " + this.floorNumber);
        System.out.println();
    }
}
