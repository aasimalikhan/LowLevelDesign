package org.example.designScenarios.designElevatorManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floors;
    private ElevatorSystem elevatorSystem;

    public Building(int totalFloors) {
        this.elevatorSystem = new ElevatorSystem();
        this.floors = new ArrayList<>();
        for (int i = 0; i < totalFloors; i++) {
            floors.add(new Floor(i, i));
        }
    }
}
