package org.example.solidprinciples.factoryPattern.code;

public class code {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(Shapes.CIRCLE);
        shape.draw();
    }
}
