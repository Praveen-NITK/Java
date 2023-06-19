package org.practice.enums;



public class BasicEnum {
    enum UserStatus{
        PENDING,
        ACTIVE,
        DELETED,
        INACTIVE
    }

    public static void main(String[] args) {
        System.out.println(UserStatus.ACTIVE);
    }
}
