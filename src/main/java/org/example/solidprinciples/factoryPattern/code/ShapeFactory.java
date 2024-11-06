package org.example.solidprinciples.factoryPattern.code;

public class ShapeFactory {
    Shape getShape(Shapes shape)
    {
        switch (shape)
        {
            case Shapes.CIRCLE:
            {
                return new Circle();
            }
            case Shapes.RECTANGLE:
            {
                return new Rectangle();
            }
            case Shapes.SQUARE:
            {
                return new Square();
            }
            default:
            {
                return null;
            }
        }
    }
}
