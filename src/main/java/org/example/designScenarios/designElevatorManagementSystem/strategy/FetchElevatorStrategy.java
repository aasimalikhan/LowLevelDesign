package org.example.designScenarios.designElevatorManagementSystem.strategy;

import org.example.designScenarios.designElevatorManagementSystem.models.ElevatorCar;

import java.util.List;

public interface FetchElevatorStrategy {
    ElevatorCar findElevatorCar(List<ElevatorCar> elevators);
}
