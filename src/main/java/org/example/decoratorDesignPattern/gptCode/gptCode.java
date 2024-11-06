package org.example.decoratorDesignPattern.gptCode;

import org.example.decoratorDesignPattern.gptCode.base.Coffee;
import org.example.decoratorDesignPattern.gptCode.base.ColdCoffee;
import org.example.decoratorDesignPattern.gptCode.decorator.CoffeeDecorator;
import org.example.decoratorDesignPattern.gptCode.decorator.SugarDecorator;

public class gptCode {
    public static void main(String[] args) {
        Coffee coldCoffee = new ColdCoffee();
        CoffeeDecorator sugar = new SugarDecorator(coldCoffee);

        System.out.println("cold coffee with sugar price: " + sugar.cost());
        System.out.println("cold coffee with sugar description " + sugar.getDescription());
    }
}
