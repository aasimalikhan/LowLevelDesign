package org.example.solidprinciples.flyweightDesignPattern.goodCode.scenario1;

import org.example.solidprinciples.flyweightDesignPattern.Sprites;

public class RoboticDog implements IRobot {
    private String type;
    private Sprites body;

    RoboticDog(String type, Sprites body)
    {
        this.type = type;
        this.body = body;
    }
    public String getType()
    {
        return type;
    }
    public Sprites getBody()
    {
        return body;
    }
    @Override
    public void display(int x, int y) {
    }
}
