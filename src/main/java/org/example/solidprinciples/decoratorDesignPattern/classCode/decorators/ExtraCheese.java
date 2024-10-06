package org.example.solidprinciples.decoratorDesignPattern.classCode.decorators;

import org.example.solidprinciples.decoratorDesignPattern.classCode.baseClasses.BasePizza;

public class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;

    public ExtraCheese(BasePizza pizza)
    {
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
