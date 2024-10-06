package org.example.solidprinciples.openClosePrinciple.ex2.goodCode;

public class Rectangle extends Shape{
    private double length;
    private double breadth;
    public Rectangle(double length, double breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    double calculateArea() {
        return length * breadth;
    }
}
