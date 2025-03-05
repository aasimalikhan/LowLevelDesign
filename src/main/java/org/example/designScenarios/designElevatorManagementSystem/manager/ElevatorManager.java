package org.example.designScenarios.designElevatorManagementSystem.manager;

import org.example.designScenarios.designElevatorManagementSystem.models.*;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private final List<Elevator> elevatorList;

    public ElevatorManager(int elevatorCount)
    {
        this.elevatorList = new ArrayList<>(elevatorCount);
    }

    public synchronized void requestElevatorAtFloor(int floor)
    {
        //need an elevator to serve the user at floor (floor - param)
        ElevatorRequest elevatorRequest = new ElevatorArrivalRequest(floor);
        assignArrivalElevator(elevatorRequest);
    }

//    public synchronized void requestElevatorMovementToFloor(Elevator elevator, int floor)
//    {
//        ElevatorRequest elevatorRequest = new ElevatorDepartureRequest(floor);
//        elevator.addDestination(elevatorRequest);
//        elevator
//    }

    private void assignArrivalElevator(ElevatorRequest elevatorRequest)
    {
        Elevator arrivalElevator = findArrivalElevator(elevatorRequest.getToFloor());
        arrivalElevator.addDestination(elevatorRequest);
    }

    private Elevator findArrivalElevator(int floorNumber) {
        Elevator servingElevator = null;
        int shortestDistance = Integer.MAX_VALUE;

        for(Elevator elevator : elevatorList)
        {
            int distance = calculateDistance(elevator, floorNumber);
            if(distance < shortestDistance) {
                shortestDistance = distance;
                servingElevator = elevator;
            }
        }
        return servingElevator;
    }

    private int calculateDistance(Elevator elevator, int requestFloor)
    {
        int currentFloor = elevator.getCurrentFloor();
        Direction elevatorDirection = elevator.getDirection();

        if(elevatorDirection == Direction.IDLE)
        {
            return Math.abs(requestFloor - currentFloor);
        }

        if((elevatorDirection == Direction.UP && requestFloor >= currentFloor) || (elevatorDirection == Direction.DOWN && requestFloor <= currentFloor))
        {
            return Math.abs(requestFloor - currentFloor);
        }

        return 1000 + Math.abs(requestFloor - currentFloor);
    }
}
