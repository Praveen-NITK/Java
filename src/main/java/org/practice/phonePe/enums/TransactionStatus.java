package org.practice.phonePe.enums;

public enum TransactionStatus {
    INITIATED,
    PENDING,
    SUCCESS,
    FAILED;

    public String value() {
        return name();
    }

    public static TransactionStatus fromValue(String v) {
        return valueOf(v);
    }
}
