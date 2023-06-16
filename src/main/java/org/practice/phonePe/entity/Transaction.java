package org.practice.phonePe.entity;

import phonePe.enums.InstrumentType;
import phonePe.enums.TransactionStatus;

import java.math.BigDecimal;

public class Transaction {
    private String transactionId;
    private String idempotentKey;
    private String description;
    private String failureCode;
    private String failureMessage;
    private InstrumentType instrumentType;
    private TransactionStatus status;
    private Integer processingEntity;
    private Double amount;
    private Account payer;
    private Account payee;

    public Transaction(String transactionId, String idempotentKey, String description, String failureCode,
                       String failureMessage, InstrumentType instrumentType, TransactionStatus status,
                       Integer processingEntity, double amount, Account payer, Account payee) {
        this.transactionId = transactionId;
        this.idempotentKey = idempotentKey;
        this.description = description;
        this.failureCode = failureCode;
        this.failureMessage = failureMessage;
        this.instrumentType = instrumentType;
        this.status = status;
        this.processingEntity = processingEntity;
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getIdempotentKey() {
        return idempotentKey;
    }

    public void setIdempotentKey(String idempotentKey) {
        this.idempotentKey = idempotentKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Integer getProcessingEntity() {
        return processingEntity;
    }

    public void setProcessingEntity(Integer processingEntity) {
        this.processingEntity = processingEntity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getPayer() {
        return payer;
    }

    public void setPayer(Account payer) {
        this.payer = payer;
    }

    public Account getPayee() {
        return payee;
    }

    public void setPayee(Account payee) {
        this.payee = payee;
    }
}
