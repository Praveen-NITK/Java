package org.practice.enums;

public class CompareEnum {
    enum Status{
        INITIATED,
        FAILED,
        ACTIVE
    }
    // To compare enum use ==
    public static void main(String[] args) {
        if (Status.ACTIVE==Status.INITIATED)
            System.out.println("Equal Enums");
        else
            System.out.println("Non Equal Enum");
    }
}
