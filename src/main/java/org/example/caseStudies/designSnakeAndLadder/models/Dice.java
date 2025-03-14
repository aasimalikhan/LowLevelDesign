package org.example.caseStudies.designSnakeAndLadder.models;

import java.util.Random;

public class Dice {
    int diceCount;
    static int min = 1;
    static int max = 6;

    public Dice(int diceCount)
    {
        this.diceCount = diceCount;
    }
    public int rollDice()
    {
        return new Random().nextInt(max) + min;
    }
}
