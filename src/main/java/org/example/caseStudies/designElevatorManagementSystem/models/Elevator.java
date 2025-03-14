package org.example.caseStudies.designElevatorManagementSystem.models;

import org.example.caseStudies.designElevatorManagementSystem.manager.FloorManager;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator extends Thread {
    private static Integer idCounter = 10001;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private final String elevatorId;
    private final Queue<ElevatorRequest> destinationRequests;
    private final Object lock = new Object();

    public Elevator(int initialFloor)
    {
        this.elevatorId = String.valueOf(idCounter++);
        this.currentFloor = initialFloor;
        this.direction = Direction.IDLE;
        this.elevatorState = ElevatorState.READY;
        this.destinationRequests = new PriorityQueue<>();
    }

    @Override
    public void run() {
        this.elevatorState = ElevatorState.RUNNING;
        while(!isInterrupted())
        {
            try {
                if(destinationRequests.isEmpty())
                {
                    synchronized (lock) {
                        elevatorState = ElevatorState.WAITING;
                        direction = Direction.IDLE;
                        lock.wait();
                    }
                }
                else {

                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.elevatorState = ElevatorState.STOPPED;
    }

    private void moveToNextFloor() throws InterruptedException {
        try {
            int nextFloor = getNextDestination();
            if(nextFloor > currentFloor)
            {
                this.direction = Direction.UP;
            }
            else if(nextFloor < currentFloor)
            {
                this.direction = Direction.DOWN;
            }

            while(currentFloor != nextFloor)
            {
                Thread.sleep(1000);
                if(direction == Direction.UP)
                {
                    currentFloor++;
                }
                else {
                    currentFloor--;
                }
                System.out.println("Elevator: " + this.elevatorId + " reached floor " + this.currentFloor);
                checkAndProcessFloor();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void checkAndProcessFloor() throws InterruptedException {
        Optional<ElevatorRequest> elevatorRequest = destinationRequests.stream().filter((request) -> request.getToFloor() == currentFloor).findFirst();
        if(elevatorRequest.isPresent())
        {
            if(elevatorRequest.get().getRequestType().equals(RequestType.ARRIVAL))
            {
                try {
                    Floor floor = FloorManager.getInstance().getFloor(currentFloor);
                    floor.update(this);
                } catch (Exception e)
                {
                    /*TODO*/ System.out.println("Floor does not exist");
                }
            }
            destinationRequests.remove(elevatorRequest.get());
            System.out.println("Elevator " + this.elevatorId + " stopping at floor " + this.currentFloor);
            Thread.sleep(2000);
        }
    }


    private int getNextDestination() throws Exception {
        Optional<Integer> nextDestination = Optional.empty();
        if(direction == Direction.UP)
        {
            nextDestination = destinationRequests.stream()
                .map(ElevatorRequest::getToFloor)
                .filter(toFloor -> toFloor >= this.currentFloor)
                .min(Integer::compare);
        }
        else {
            nextDestination = destinationRequests.stream()
                    .map(ElevatorRequest::getToFloor)
                    .filter(toFloor -> toFloor <= this.currentFloor)
                    .min(Integer::compare);
        }

        if (nextDestination.isPresent())
        {
            return nextDestination.get();
        }
        if(!destinationRequests.isEmpty())
        {
            return destinationRequests.peek().getToFloor();
        }
        throw new Exception("saddasd");
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public void addDestination(ElevatorRequest elevatorRequest)
    {
        synchronized (lock) {
            this.destinationRequests.add(elevatorRequest);
            if(elevatorState == ElevatorState.WAITING)
            {
                lock.notify();
            }
        }
    }
}
