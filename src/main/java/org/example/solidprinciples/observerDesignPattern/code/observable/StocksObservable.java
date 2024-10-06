package org.example.solidprinciples.observerDesignPattern.code.observable;

import org.example.solidprinciples.observerDesignPattern.code.observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int count);
    public int getStockCount();
}
