package org.practice.phonePe.payment;

import org.practice.phonePe.entity.Transaction;
import org.practice.phonePe.enums.TransactionStatus;

import java.util.LinkedList;
import java.util.List;

public class PaymentController {

    private List<Transaction> transactionList= new LinkedList<>();

    public Transaction initiatePayment(Transaction transaction){
        //Basic validation for mandatory fields in request like amount, payer, payee etc

        //Other validations based on instrumentType like card details for cardBased payment


        Transaction finalTransaction = transaction;

        //Duplicate check
        if(transactionList.stream().filter(t->t.getIdempotentKey().equals(finalTransaction.getIdempotentKey())).findAny().isPresent()){
            //return error message with
            if(!transaction.getStatus().equals(TransactionStatus.SUCCESS) || !transaction.getStatus().equals(TransactionStatus.FAILED)) {
                transaction.setFailureMessage("Transaction already in progress");
            }
            return transaction;
        }
        else {
            transaction.setStatus(TransactionStatus.INITIATED);
            transactionList.add(transaction);
            PaymentAdapter paymentAdapter= new PaymentAdapter();
            transaction=paymentAdapter.initiatePaymentWithBank(transaction);
            return transaction;
        }
    }
}
