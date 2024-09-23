package org.example.solidprinciples.openClosePrinciple.ex3_ex2optimized;

public class Rectangle implements Shape{
    private double length;
    private double breadth;
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        //implementation for area calculation of rectangle;
        return 12;
    }
}
