package org.practice.DesignPattern.FactoryPattern;

public class NotificationFactory {
    public Notification getNotification(String type){
        Notification notification=null;
        switch (type){
            case "SMS":
                notification= new SMSNotification();
                break;
            case "Email":
                notification=  new EmailNotification();
                break;
            case "Push":
                notification= new PushNotification();
                break;
        }
        return notification;
    }
}
