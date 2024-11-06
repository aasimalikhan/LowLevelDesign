package org.example.factoryPattern.gptCode;

public class gptCode {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification emailNotification = factory.getNotification("EMAIL");
        emailNotification.notifyUser();

        Notification smsNotification = factory.getNotification("SMS");
        smsNotification.notifyUser();

        Notification pushNotification = factory.getNotification("PUSH");
        pushNotification.notifyUser();
    }
}
