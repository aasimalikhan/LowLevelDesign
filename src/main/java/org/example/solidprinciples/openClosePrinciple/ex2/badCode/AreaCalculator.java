package org.example.solidprinciples.openClosePrinciple.ex2.badCode;

public class AreaCalculator {
    public double calculateArea(Shape shape)
    {
        if(shape.type.equals("Circle"))
        {
            return Math.PI * 5 * 5;
        }
        else if(shape.type.equals("Rectangle"))
        {
            return 10 * 20;
        }
        return 0;
    }
}
