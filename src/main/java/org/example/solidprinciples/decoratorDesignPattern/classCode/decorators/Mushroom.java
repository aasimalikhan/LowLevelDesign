package org.example.solidprinciples.decoratorDesignPattern.classCode.decorators;

import org.example.solidprinciples.decoratorDesignPattern.classCode.baseClasses.BasePizza;

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
