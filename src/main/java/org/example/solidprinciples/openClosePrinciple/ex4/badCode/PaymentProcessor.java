package org.example.solidprinciples.openClosePrinciple.ex4.badCode;

public class PaymentProcessor {
    public void processPayment(String paymentType)
    {
        if(paymentType.equals("CreditCard"))
        {
            //process credit card payment
        }
        else if(paymentType.equals("Paypal"))
        {
            //process paypal payment
        }
        else if(paymentType.equals("Bitcoin"))
        {
            //process bitcoin payment
        }
    }
}
