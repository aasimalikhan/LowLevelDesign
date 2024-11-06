package org.example.solidprinciples.templateMethodDesignPattern.code;

public class PaymentToPeerFlow extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("validating request");
        System.out.println("....");
        System.out.println("request validated");
    }

    @Override
    public void calculateFees() {
        System.out.println("calculating fees");
        System.out.println("....");
        System.out.println("calculated fees");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debitting amount xyz");
        System.out.println("....");
        System.out.println("Debitted amount xyz");
    }

    @Override
    public void creditAmount() {
        System.out.println("crediting amount xyz");
        System.out.println("....");
        System.out.println("crediting amount xyz");
    }
}
