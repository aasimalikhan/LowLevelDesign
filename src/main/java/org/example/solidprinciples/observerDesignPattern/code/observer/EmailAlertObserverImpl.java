package org.example.solidprinciples.observerDesignPattern.code.observer;

import org.example.solidprinciples.observerDesignPattern.code.observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    public String emailId;
    public StocksObservable observable;
    public EmailAlertObserverImpl(String emailId, StocksObservable observable)
    {
        this.emailId = emailId;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMail(emailId, "Product back in stock hurry");
    }
    public void sendMail(String emailId, String message)
    {
        System.out.println("Mail sent to " + emailId + ", message: " + message);
    }
}
