package org.example.solidprinciples.decoratorDesignPattern.gptCode.decorator;

import org.example.solidprinciples.decoratorDesignPattern.gptCode.base.Coffee;

public class MilkDecorator extends CoffeeDecorator{
    public Coffee baseCoffee;
    public MilkDecorator(Coffee coffee)
    {
        this.baseCoffee = coffee;
    }
    @Override
    public String getDescription() {
        return this.baseCoffee.getDescription() + ", milk";
    }

    @Override
    public double cost() {
        return this.baseCoffee.cost() + 1.50;
    }
}
