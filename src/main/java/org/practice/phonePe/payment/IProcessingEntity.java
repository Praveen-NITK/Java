package org.practice.phonePe.payment;

import phonePe.entity.Transaction;

import java.util.concurrent.TimeoutException;

public interface IProcessingEntity {
    public boolean processPayment(Transaction transaction) throws TimeoutException;
}
