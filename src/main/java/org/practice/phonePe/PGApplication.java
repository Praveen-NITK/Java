package org.practice.phonePe;

import org.practice.phonePe.entity.Account;
import org.practice.phonePe.entity.Transaction;
import org.practice.phonePe.enums.InstrumentType;
import org.practice.phonePe.onboarding.IOnBoardingHandler;
import org.practice.phonePe.onboarding.OnBoardingHandlerImpl;
import org.practice.phonePe.payModes.IPayModeHandler;
import org.practice.phonePe.payModes.PayModeHandlerImpl;
import org.practice.phonePe.payment.PaymentController;
import sun.management.counter.StringCounter;

import java.util.ArrayList;
import java.util.List;

public class PGApplication {



    private static IOnBoardingHandler merchantOnBoarding;
    private static IPayModeHandler payModeHandler;
    private static PaymentController paymentController;

    //DependencyInjection
    public PGApplication(IOnBoardingHandler merchantOnBoarding, IPayModeHandler payModeHandler, PaymentController paymentController) {
        this.merchantOnBoarding=merchantOnBoarding;
        this.payModeHandler= payModeHandler;
        this.paymentController=paymentController;
    }

    /**
     * Question
     *
     * Payments is an integral component of any e-commerce or fintech.
     * With the advent of digital india, we have seen different types of payments ecosystem rising up - Payments gateways, UPI, Rupay Network etc. These are easy to integrate and any org can get started with this in a matter of days.
     *
     * With the onset of different payment players, organizations integrate different payment gateways and shuffle between them to suit their use cases best.
     *
     * Based on use cases, customers can opt for payment via card / upi / net banking etc. Below is the general runbook for making a payment.
     *
     * Select a pay mode
     * Enter details
     * For netbanking - enter username and password
     * For credit / debit card - enter card details ( number, expiry, cvv etc )
     * UPI - enter vpa
     * Implement a payments gateway which help facilitate a payment for its client, below points should be kept in mind while implementation
     *
     * Real world example
     *
     * Flipkart has integrated multiple PGs like Razorpay, Citrus, PaySafe, CCAvenue etc. They use these PGs based on different use cases. For example, divert all credit card transaction to RazorPay while Netbanking goes to CCAvenue.
     *
     * These PGs internally have direct integration with different banks which facilitate the payments.
     *
     * Expectation from this code is to build PG like a Razorpay / CCAvenue which allows onboarding clients like Flipkart and process a transaction.
     *
     * Client in this case is Flipkart ( PG can have more than one clients )
     * PG is what candidate has to implement
     * PG can have more than one bank, candidates are free to implement a mock or full fledged class
     *
     * Feature Requirement:
     *
     * PG should support onboarding multiple clients.
     * PG should have multiple bank integrations ( like HDFC, ICICI, SBI etc )
     * PG should have facility to support different payment methods - UPI, Credit / Debit Card, Netbanking etc
     * PG should have facility to divert to specific bank based on certain criteria - a router basically - (for e.g. all credit card transaction goes to HDFC and netbanking is redirected to ICICI )
     * PG should have facility to allocate specific percentage between different banks - say bank1 takes 30% of total traffic while remaining 70% go to bank2
     * Clients should have an option to opt for specific payment methods. - only UPI, everything except netbanking etc
     * Assumptions:
     *
     * Banks can randomly return success / failure - candidates can create a random function to mock this behaviour.
     * Payments should be processed using an instrument only if specific parameter for that payment is passed - netbanking might need user id / password but credit card will only work with card details
     * Banks require OTP verification after instrument details are verified ( applicable for netbanking / card transaction ) for sake of simplicity, transactions will go through without OTP.
     * Code Expectation:
     *
     * Everything has to be in memory.
     * Candidate can opt for any language for implementation
     * Simple and basic function are expected as entry point - no marks for providing fancy restful API or framework implementation
     * Because this is a machine coding round, heavy focus would be given on code quality, candidate should not focus too much time on algo which compromises with implementation time
     * Requirements - below are various functions that should be supported with necessary parameters passed
     *
     * addClient() - add a client in PG
     * removeClinet() - remove client from PG
     * hasClient() - does a client exist in the PG?
     * listSupportedPaymodes() - show paymodes support by PG. if a client is passed as parameter, all supported paymodes for the clients should be shown.
     * addSupportForPayMode() - add paymodes support in the PG. If a client is passed as parameter, add paymode for the clients.
     * removePaymode() - remove paymode ( both from PG or client basis parameter)
     * showDistribution() - show active distribution percentage of router
     * makePayment( //necessary payment details )
     * Evaluation criteria:
     *
     * Working code
     * Code readability
     * Implementation of OOPs / OOD principles with proper Separation of concerns
     * Testability - a TDD approach ( not to be mixed with test cases )
     * Language proficiency
     * phonePe.Test Cases ( bonus points )
     * Extension problem:
     *
     * Can a router dynamically switch the traffic basis success percentage of Bank?
     * Can the router switch based on payment instruments as well instead of just Bank?
     * [execution time limit] 3 seconds (java)
     * @param args
     */
    public static void main(String[] args) {
        new PGApplication(OnBoardingHandlerImpl.getMerchantOnBoardingInstance(),new PayModeHandlerImpl(OnBoardingHandlerImpl.getMerchantOnBoardingInstance()),new PaymentController());

        Merchant flipkart = getFlipKart();
        Merchant bookMyShow = getBookMyShow();
        Merchant redBus = getRedBus();

        System.out.println("On Boarding Merchants");
        merchantOnBoarding.addClient(flipkart);
        merchantOnBoarding.addClient(bookMyShow);
        merchantOnBoarding.addClient(redBus);

        System.out.println("Removing Merchant");
        merchantOnBoarding.removeClient(bookMyShow);

        System.out.println("is flipkart exists? "+merchantOnBoarding.hasClient(flipkart));
        System.out.println("is bookMyShow exists? "+merchantOnBoarding.hasClient(bookMyShow));

        System.out.println("Configuring PG supported Instruments");
        payModeHandler.addSupportForPayMode(null,InstrumentType.CC);
        payModeHandler.addSupportForPayMode(null,InstrumentType.DC);

        System.out.println("Configuring Merchant supported Instruments");
        payModeHandler.addSupportForPayMode(flipkart,InstrumentType.UPI);
        payModeHandler.addSupportForPayMode(redBus,InstrumentType.NB);
        payModeHandler.addSupportForPayMode(bookMyShow,InstrumentType.WALLET);


        System.out.println("Fetch PG supported Instruments");
        System.out.println(payModeHandler.supportedPayModes(null));

        System.out.println("Fetch Merchant supported Instruments");
        System.out.println(payModeHandler.supportedPayModes(flipkart));


        System.out.println("Remove PG supported Instruments");
        payModeHandler.removePayMode(null, InstrumentType.CC);
        System.out.println("post CC removal: "+payModeHandler.supportedPayModes(null));

        System.out.println("Remove Merchant supported Instruments");
        payModeHandler.removePayMode(flipkart, InstrumentType.CC);
        System.out.println("post CC removal from merchant: "+payModeHandler.supportedPayModes(flipkart));

        System.out.println("Initiating payment");
        Transaction transaction=paymentController.initiatePayment(new Transaction("123","idempotent","payment",null,null,InstrumentType.CC,null,null,100.0,new Account(){{setName("praveen");}},new Account(){{setName("flipkart");}}));
        System.out.println(transaction.getTransactionId());
        System.out.println(transaction.getStatus());
    }

    private static Merchant getFlipKart() {
        List<InstrumentType> inst=new ArrayList<>();
        inst.add(InstrumentType.NB);
        inst.add(InstrumentType.CC);
        inst.add(InstrumentType.DC);

        Merchant merchant= new Merchant(123,"Flipkart",inst);
        return merchant;
    }
    private static Merchant getBookMyShow() {
        List<InstrumentType> inst=new ArrayList<>();
        inst.add(InstrumentType.NB);
        inst.add(InstrumentType.UPI);

        Merchant merchant= new Merchant(456,"bookMyShow",inst);
        return merchant;
    }
    private static Merchant getRedBus() {
        List<InstrumentType> inst=new ArrayList<>();
        inst.add(InstrumentType.NB);
        inst.add(InstrumentType.WALLET);

        Merchant merchant= new Merchant(789,"redBus",inst);
        return merchant;
    }
}
