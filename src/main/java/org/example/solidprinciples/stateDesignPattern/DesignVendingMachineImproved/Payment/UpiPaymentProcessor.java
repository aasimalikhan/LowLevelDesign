package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Payment;

public class UpiPaymentProcessor extends PaymentProcessor{
    @Override
    protected void initiatePayment(double amount) {
        System.out.println("Initiating upi Payment");
    }

    @Override
    protected boolean validatePaymentDetails() {
        System.out.println("Validating payment Details");
        return true;
    }

    @Override
    protected boolean processTransaction() {
        System.out.println("Processing UPI Transaction");
        return true;
    }
}