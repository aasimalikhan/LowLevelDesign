package org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.Implementation;

import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightContext;
import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.State;

public class GreenState implements State {
    @Override
    public void switchLight(TrafficLightContext context) {
        System.out.println("Green Light - Go! Switching to Yellow...");
        context.setState(new YellowState());
    }
}
