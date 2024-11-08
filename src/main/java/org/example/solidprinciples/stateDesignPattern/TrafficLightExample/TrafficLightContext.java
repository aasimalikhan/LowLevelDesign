package org.example.solidprinciples.stateDesignPattern.TrafficLightExample;

import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.Implementation.RedState;
import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.State;

public class TrafficLightContext {
    private State state;
    public TrafficLightContext() {
        this.state = new RedState();
    }
    public void setState(org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.State state)
    {
        this.state = state;
    }
    public void switchLight() {
        state.switchLight(this);
    }
}
