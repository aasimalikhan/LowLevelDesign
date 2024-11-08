package org.example.solidprinciples.stateDesignPattern.TrafficLightExample;

public class TrafficLightExample {
    public static void main(String[] args) {
        TrafficLightContext trafficLightContext = new TrafficLightContext();
        trafficLightContext.switchLight();
        trafficLightContext.switchLight();
        trafficLightContext.switchLight();
        trafficLightContext.switchLight();
    }
}
