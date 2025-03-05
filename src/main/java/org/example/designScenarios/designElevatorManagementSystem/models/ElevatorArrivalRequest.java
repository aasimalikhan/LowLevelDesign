package org.example.designScenarios.designElevatorManagementSystem.models;

public class ElevatorArrivalRequest extends ElevatorRequest{
    public ElevatorArrivalRequest(int toFloor) {
        super(toFloor);
    }

    public RequestType getRequestType() {
        return RequestType.ARRIVAL;
    }
}
