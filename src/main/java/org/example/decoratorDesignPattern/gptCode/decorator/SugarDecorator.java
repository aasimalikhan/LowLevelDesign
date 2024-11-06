package org.example.decoratorDesignPattern.gptCode.decorator;

import org.example.decoratorDesignPattern.gptCode.base.Coffee;

public class SugarDecorator extends CoffeeDecorator{
    public Coffee baseCoffee;
    public SugarDecorator(Coffee coffee)
    {
        this.baseCoffee = coffee;
    }
    @Override
    public String getDescription() {
        return this.baseCoffee.getDescription() + ", sugar";
    }

    @Override
    public double cost() {
        return this.baseCoffee.cost() + 1.00;
    }
}
