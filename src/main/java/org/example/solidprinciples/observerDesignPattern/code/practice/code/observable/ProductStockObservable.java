package org.example.solidprinciples.observerDesignPattern.code.practice.code.observable;

import org.example.solidprinciples.observerDesignPattern.code.practice.code.observer.NotificationAlertObserver;

public interface ProductStockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifyObservers();
    public void setStockCount(int count);
    public int getStockCount();
    
}
