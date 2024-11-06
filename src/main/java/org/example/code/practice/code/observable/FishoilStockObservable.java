package org.example.code.practice.code.observable;

import org.example.code.practice.code.observer.NotificationAlertObserver;

import java.util.List;

public class FishoilStockObservable implements ProductStockObservable{
    public List<NotificationAlertObserver> observerList;
    public int stockCount = 0;
    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer: observerList)
        {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int count) {
        if(stockCount == 0)
        {
            notifyObservers();
        }
        stockCount = stockCount + count;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
