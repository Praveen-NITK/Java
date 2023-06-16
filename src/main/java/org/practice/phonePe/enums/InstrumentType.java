package org.practice.phonePe.enums;

public enum InstrumentType {
    CC,
    DC,
    NB,
    UPI,
    WALLET;
    public String value() {
        return name();
    }
    public static InstrumentType fromValue(String v) {
        return valueOf(v);
    }
}
