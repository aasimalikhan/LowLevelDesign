package org.example.designScenarios.designFlightManagement.strategy.payment;

public class UPIPaymentStrategy implements PaymentStrategy{

    @Override
    public boolean pay(double amount) {
        System.out.println("Amount paid using UPI");
        return true;
    }
}
