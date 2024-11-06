package org.example.solidprinciples.observerDesignPattern.code.practice.code.observer;

import org.example.solidprinciples.observerDesignPattern.code.practice.code.observable.ProductStockObservable;

public class EmailAlertObserver implements NotificationAlertObserver {
    public ProductStockObservable observable;
    public String email;
    public EmailAlertObserver(String email, ProductStockObservable observable)
    {
        this.email = email;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMail(email, "Product back in stock hurry");
    }
    public void sendMail(String email, String message)
    {
        System.out.println("sent email to " + email + " with data: " + message);
    }
}
