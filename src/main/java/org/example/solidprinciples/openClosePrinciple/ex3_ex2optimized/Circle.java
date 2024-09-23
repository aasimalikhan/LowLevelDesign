package org.example.solidprinciples.openClosePrinciple.ex3_ex2optimized;

public class Circle implements Shape{
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        //implementation for calculate area of circle
        return 23;
    }
}
