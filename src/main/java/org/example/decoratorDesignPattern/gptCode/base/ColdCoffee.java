package org.example.decoratorDesignPattern.gptCode.base;

public class ColdCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Cold Coffee";
    }

    @Override
    public double cost() {
        return 7.00;
    }
}
