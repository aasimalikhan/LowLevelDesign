package org.example.templateMethodDesignPattern.code;

public class templateMethodDesignPatterncode {
    public static void main(String[] args) {
        PaymentFlow paymentToPeer = new PaymentToPeerFlow();
        paymentToPeer.sendMoney();
    }
}
