package org.practice.phonePe.payment;

import phonePe.entity.Transaction;

import java.util.Random;
import java.util.concurrent.TimeoutException;

public class HDFCBank implements IProcessingEntity{

    @Override
    public boolean processPayment(Transaction transaction) throws TimeoutException {
        //Call transaction request to bank and respond with success/failure

        // creating Random object
        Random rd = new Random();
        return rd.nextBoolean();
    }
}
