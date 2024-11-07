package org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.Implementation;

import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightContext;
import org.example.solidprinciples.stateDesignPattern.TrafficLightExample.TrafficLightStates.State;

public class YellowState implements State {
    @Override
    public void switchLight(TrafficLightContext context) {
        System.out.println("Yellow Light - Prepare to Stop! Switching to Red...");
        context.setState(new RedState());
    }
}
