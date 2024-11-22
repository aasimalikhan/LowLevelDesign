package org.example.designScenarios.designElevatorManagementSystem.models;

import java.util.List;

public class ElevatorCar {
    long id;
    private static int idCounter = 1;
    int floorNumber;
    Door elevatorDoor;
    ElevatorState elevatorState;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        ElevatorCar.idCounter = idCounter;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Door getElevatorDoor() {
        return elevatorDoor;
    }

    public void setElevatorDoor(Door elevatorDoor) {
        this.elevatorDoor = elevatorDoor;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public Direction getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(Direction elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    Direction elevatorDirection;
    ElevatorButtons elevatorButtons;
    List<Request> requests;

    public ElevatorCar()
    {
        this.id = idCounter++;
        this.elevatorState = ElevatorState.IDLE;
        this.floorNumber = 0;
    }

    public void addElevatorRequest(Request request)
    {
        if(requests.size() == 0)
            requests.add(request);
    }

    public synchronized Request getNextRequest() {
        while (requests.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requests.remove(0);
    }

    private void processRequest(Request request)
    {
        int startFloor = floorNumber;
        int destinationFloor = 1;
        elevatorState = ElevatorState.MOVING;
        if (startFloor < destinationFloor) {
            elevatorDirection = Direction.UP;
            for (int i = startFloor; i <= destinationFloor; i++) {
                floorNumber = i;
                System.out.println("Elevator " + id + " reached floor " + floorNumber);
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (startFloor > destinationFloor) {
            elevatorDirection = Direction.DOWN;
            for (int i = startFloor; i >= destinationFloor; i--) {
                floorNumber = i;
                System.out.println("Elevator " + id + " reached floor " + floorNumber);
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        elevatorDoor.state = DoorState.OPEN;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        elevatorDoor.state = DoorState.CLOSE;
        elevatorState = ElevatorState.IDLE;
    }
    public synchronized void processRequest() {
        while(true) {
            while(!requests.isEmpty())
            {
                Request request = getNextRequest();
                processRequest(request);
            }
        }
    }

    public void run() {
        processRequest();
    }

}
