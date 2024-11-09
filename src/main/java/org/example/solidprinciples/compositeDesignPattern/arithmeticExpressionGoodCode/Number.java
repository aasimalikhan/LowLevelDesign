package org.example.solidprinciples.compositeDesignPattern.arithmeticExpressionGoodCode;

public class Number implements ArithmeticExpression{
    int value;
    public Number(int value)
    {
        this.value = value;
    }
    @Override
    public int evaluate() {
        System.out.println("Number value is: " + value);
        return value;
    }
}
