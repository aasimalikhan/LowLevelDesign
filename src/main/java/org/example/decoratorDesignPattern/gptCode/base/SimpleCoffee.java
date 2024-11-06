package org.example.decoratorDesignPattern.gptCode.base;

public class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.00;
    }
}
