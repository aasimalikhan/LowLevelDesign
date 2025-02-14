package org.example.designScenarios.designFlightManagement.strategy.payment;

public class DebitCardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Amount paid using Debit card");
        return true;
    }
}
