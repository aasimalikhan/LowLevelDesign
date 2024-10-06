package org.example.solidprinciples.observerDesignPattern.code.observer;

import org.example.solidprinciples.observerDesignPattern.code.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    public StocksObservable observable;
    public String phoneNo;
    public MobileAlertObserverImpl(String phoneNo, StocksObservable observable)
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
        System.out.println("Message sent to " + phoneNo + ", message: " + message);
    }
}
