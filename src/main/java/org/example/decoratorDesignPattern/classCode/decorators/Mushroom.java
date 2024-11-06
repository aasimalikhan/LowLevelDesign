package org.example.decoratorDesignPattern.classCode.decorators;

import org.example.decoratorDesignPattern.classCode.baseClasses.BasePizza;

public class Mushroom extends ToppingDecorator{
    public BasePizza basePizza;
    public Mushroom(BasePizza pizza)
    {
        this.basePizza = pizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 30;
    }
}
