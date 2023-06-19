package org.practice.enums;

public class LoopEnum {
    enum Status{
        INITIATED,
        FAILED,
        ACTIVE
    }

    public static void main(String[] args) {
        for (Status s:Status.values()) {
            System.out.println(s);
        }
    }
}
