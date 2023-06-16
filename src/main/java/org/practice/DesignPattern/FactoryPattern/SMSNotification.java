package org.practice.DesignPattern.FactoryPattern;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}
