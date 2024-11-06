package org.example.decoratorDesignPattern.classCode;

import org.example.decoratorDesignPattern.classCode.baseClasses.BasePizza;
import org.example.decoratorDesignPattern.classCode.baseClasses.Farmhouse;
import org.example.decoratorDesignPattern.classCode.baseClasses.Margherita;
import org.example.decoratorDesignPattern.classCode.baseClasses.VegDelight;
import org.example.decoratorDesignPattern.classCode.decorators.ExtraCheese;
import org.example.decoratorDesignPattern.classCode.decorators.Mushroom;

public class classCodeRun {
    public static void main(String[] args) {
        BasePizza farmhousePizza = new Farmhouse();
        BasePizza margheritaPizza = new Margherita();
        BasePizza vegDelightPizza = new VegDelight();

        BasePizza extraCheeseFarmhouse = new ExtraCheese(farmhousePizza);
        BasePizza extraCheeseMargherita = new ExtraCheese(margheritaPizza);
        BasePizza mushroomVegdelight = new Mushroom(vegDelightPizza);

        System.out.println("farmhouse price: " + farmhousePizza.cost());
        System.out.println("margherita price: " + margheritaPizza.cost());
        System.out.println("ved delight price: " + vegDelightPizza.cost());
        System.out.println("extra cheese farmhouse price: " + extraCheeseFarmhouse.cost());
        System.out.println("extra cheese margherita price: " + extraCheeseMargherita.cost());
        System.out.println("mushroom veg delight price: " + mushroomVegdelight.cost());

    }
}
