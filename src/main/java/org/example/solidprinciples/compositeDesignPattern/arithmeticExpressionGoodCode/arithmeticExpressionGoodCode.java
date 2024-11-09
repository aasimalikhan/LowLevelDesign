package org.example.solidprinciples.compositeDesignPattern.arithmeticExpressionGoodCode;

public class arithmeticExpressionGoodCode {
    public static void main(String[] args) {
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression seven = new Number(7);
        ArithmeticExpression addExpression = new Expression(one, seven, Operation.ADD);
        ArithmeticExpression parentExpression = new Expression(addExpression, two, Operation.MULTIPLY);
        System.out.println(parentExpression.evaluate());
    }
}
