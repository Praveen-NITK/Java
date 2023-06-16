package org.practice.DesignPattern.FactoryPattern;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending Push Notification");
    }
}
