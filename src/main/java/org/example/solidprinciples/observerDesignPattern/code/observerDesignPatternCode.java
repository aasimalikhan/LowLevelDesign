package org.example.solidprinciples.observerDesignPattern.code;

import org.example.solidprinciples.observerDesignPattern.code.observable.IphoneObservableImpl;
import org.example.solidprinciples.observerDesignPattern.code.observable.StocksObservable;
import org.example.solidprinciples.observerDesignPattern.code.observer.EmailAlertObserverImpl;
import org.example.solidprinciples.observerDesignPattern.code.observer.MobileAlertObserverImpl;
import org.example.solidprinciples.observerDesignPattern.code.observer.NotificationAlertObserver;

public class observerDesignPatternCode {
    public static void main(String[] args) {
        StocksObservable observable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new MobileAlertObserverImpl("9121795607", observable);
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl("8143712249", observable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("aasimalikhan54321@gmail.com", observable);


        observable.add(observer1);
        observable.add(observer2);
        observable.add(observer3);

        observable.setStockCount(10);
        observable.setStockCount(-10);
        observable.setStockCount(100);
    }
}
