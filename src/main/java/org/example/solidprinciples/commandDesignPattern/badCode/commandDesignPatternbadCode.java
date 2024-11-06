package org.example.solidprinciples.commandDesignPattern.badCode;

public class commandDesignPatternbadCode {
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();
        ac.turnOn();
        ac.setTemperature(22);
        ac.turnOff();
    }
}
