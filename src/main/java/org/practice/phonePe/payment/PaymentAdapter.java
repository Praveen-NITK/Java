package org.practice.phonePe.payment;

import org.practice.phonePe.entity.Transaction;
import org.practice.phonePe.enums.TransactionStatus;

import java.util.concurrent.TimeoutException;

/**
 * class responsible for Bank integrations
 */
public class PaymentAdapter {

    protected Transaction initiatePaymentWithBank(Transaction transaction){

        //Resolve bank from factory based on bankId
        //IProcessingEntity bank= RoutingEngine.routePayment(transaction.getPayer().getBankId());

        //Resolve bank from factory based on instrument
        IProcessingEntity bank2= RoutingEngine.routePaymentOnInstrument(transaction.getInstrumentType());

        //Resolve bank from factory based on percentage
        int currentCount=10;
        int totalCount=30;
//        IProcessingEntity bank3= RoutingEngine.routePaymentOnPercentage(currentCount,totalCount);

        try {
            //call bank's makePayment()
            if(bank2.processPayment(transaction))
                transaction.setStatus(TransactionStatus.SUCCESS);
            else
                transaction.setStatus(TransactionStatus.FAILED);

        } catch (TimeoutException e){
            transaction.setStatus(TransactionStatus.PENDING);
        } catch (Exception e){
            transaction.setStatus(TransactionStatus.FAILED);
        }
        return transaction;

    }


}
