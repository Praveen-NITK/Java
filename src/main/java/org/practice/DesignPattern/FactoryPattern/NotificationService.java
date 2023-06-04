package DesignPattern.FactoryPattern;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory= new NotificationFactory();
        Notification notification=notificationFactory.getNotification("Push");
        notification.notifyUser();
    }
}
