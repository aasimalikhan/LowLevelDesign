package org.example.code.practice.code;

import org.example.code.practice.code.observable.FishoilStockObservable;
import org.example.code.practice.code.observable.IphoneStockObservable;
import org.example.code.practice.code.observable.ProductStockObservable;
import org.example.code.practice.code.observer.EmailAlertObserver;
import org.example.code.practice.code.observer.MessageAlertObserver;
import org.example.code.practice.code.observer.NotificationAlertObserver;

public class practicecode {
    public static void main(String[] args) {
        ProductStockObservable iPhoneObservable = new IphoneStockObservable();
        ProductStockObservable fishoilObservable = new FishoilStockObservable();

        NotificationAlertObserver observer1 = new EmailAlertObserver("aasimalikhan54321@gmail.com", iPhoneObservable);
        NotificationAlertObserver observer2 = new MessageAlertObserver("9121795607", iPhoneObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserver("emaadalikhan54321@gmail.com", iPhoneObservable);

        iPhoneObservable.add(observer1);
        iPhoneObservable.add(observer2);


        iPhoneObservable.setStockCount(1);

    }
}
