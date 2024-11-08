package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Payment;

public abstract class PaymentProcessor {
    protected abstract void initiatePayment(double amount);
    protected abstract boolean validatePaymentDetails();
    protected abstract boolean processTransaction();

    public final void processPayment(double amount) throws Exception {
        initiatePayment(amount);
        if(validatePaymentDetails())
        {
            if(processTransaction())
            {
                confirmPayment();
            }
            else {
                throw new Exception("Payment Failed");
            }
        }
    }

    protected void confirmPayment() {
        System.out.println("Payment Confirmed");
    }
}