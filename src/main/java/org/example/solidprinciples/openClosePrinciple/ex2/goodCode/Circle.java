package org.example.solidprinciples.openClosePrinciple.ex2.goodCode;

public class Circle extends Shape{
    private double radius;
    public Circle(double radius)
    {
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
