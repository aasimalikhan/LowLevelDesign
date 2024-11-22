package org.example.designScenarios.designElevatorManagementSystem.models;

import org.example.designScenarios.designElevatorManagementSystem.strategy.FetchElevatorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ElevatorSystem {
    List<ElevatorCar> elevators;
    FetchElevatorStrategy elevatorFetchingStrategy;

    public ElevatorSystem()
    {
        elevators = new ArrayList<>();
    }
    public void addElevator()
    {
        ElevatorCar elevatorCar = new ElevatorCar();
        elevators.add(elevatorCar);
    }
    public ElevatorCar searchIdleElevators()
    {
        Optional<ElevatorCar> elevatorCar = elevators.stream().filter(eC -> eC.getElevatorState() == ElevatorState.IDLE).findFirst();
        if(elevatorCar.isPresent())
        {
            return elevatorCar.get();
        }
        return null;
    }
    void processElevatorRequest(Direction direction, Floor floor) throws InterruptedException {
        ElevatorCar idleElevator = searchIdleElevators();
        if(idleElevator == null)
        {
            wait();
        }
        System.out.println("Elevator: " + idleElevator.getId() + "reached at " + floor.getFloorNumber());
        Request elevatorRequest = new Request(floor.getFloorNumber());
        idleElevator.addElevatorRequest(elevatorRequest);
    }
}
