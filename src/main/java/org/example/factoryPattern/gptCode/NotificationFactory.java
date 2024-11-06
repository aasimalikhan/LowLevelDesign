package org.example.factoryPattern.gptCode;

public class NotificationFactory {
    public Notification getNotification(String type)
    {
        if (type == null || type.isEmpty())
            return null;
        if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotification();
        } else if ("SMS".equalsIgnoreCase(type)) {
            return new SMSNotification();
        } else if ("PUSH".equalsIgnoreCase(type)) {
            return new PushNotification();
        }
        return null;
    }
}
