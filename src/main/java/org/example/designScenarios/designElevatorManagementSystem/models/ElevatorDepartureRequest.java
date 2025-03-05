package org.example.designScenarios.designElevatorManagementSystem.models;

public class ElevatorDepartureRequest extends ElevatorRequest{
    public ElevatorDepartureRequest(int toFloor) {
        super(toFloor);
    }

    public RequestType getRequestType() {
        return RequestType.DEPARTURE;
    }
}
