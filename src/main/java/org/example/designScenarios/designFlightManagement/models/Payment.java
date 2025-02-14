package org.example.designScenarios.designFlightManagement.models;

public class Payment {
    private static long idCounter = 100001;
    private String id;
    private PaymentStatus paymentStatus;
    private double amount;
    private PaymentType paymentType;

    public Payment(PaymentStatus paymentStatus, double amount) {
        this.id = String.valueOf(idCounter++);
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType()
    {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
}
