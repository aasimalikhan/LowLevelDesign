package org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates;

import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightContext;

public interface State {
    void switchLight(TrafficLightContext context);
}
