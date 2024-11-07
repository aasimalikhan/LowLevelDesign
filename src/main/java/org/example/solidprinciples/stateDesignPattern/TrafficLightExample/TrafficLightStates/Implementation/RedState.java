package org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.Implementation;

import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightContext;
import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.State;

public class RedState implements State {
    @Override
    public void switchLight(TrafficLightContext context) {
        System.out.println("Red Light - Stop! Switching to Green...");
        context.setState(new GreenState());
    }
}
