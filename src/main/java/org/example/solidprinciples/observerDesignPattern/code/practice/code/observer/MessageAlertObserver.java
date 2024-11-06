package org.example.solidprinciples.observerDesignPattern.code.practice.code.observer;

import org.example.solidprinciples.observerDesignPattern.code.practice.code.observable.ProductStockObservable;

public class MessageAlertObserver implements NotificationAlertObserver{
    public ProductStockObservable observable;
    public String phoneNo;
    public MessageAlertObserver(String phoneNo, ProductStockObservable observable)
    {
        this.phoneNo = phoneNo;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMessage(phoneNo, "Product back in stock hurry");
    }
    public void sendMessage(String phoneNo, String message)
    {
        System.out.println("sent message to " + phoneNo + " with data: " + message);
    }
}
