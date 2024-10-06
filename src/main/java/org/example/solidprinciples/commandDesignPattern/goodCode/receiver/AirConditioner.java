package org.example.solidprinciples.commandDesignPattern.goodCode.receiver;

public class AirConditioner {
    boolean isOn;
    int temperature;
    public void turnOnAC()
    {
        isOn = true;
        System.out.println("AC is ON");
    }
    public void turnOffAC() {
        isOn = true;
        System.out.println("AC is OFF");
    }
    public void setTemperature(int temp)
    {
        this.temperature = temp;
        System.out.println("AC temperature set to " + temp);
    }
}
