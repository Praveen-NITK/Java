package org.practice.phonePe.payment;

import org.practice.phonePe.enums.InstrumentType;

public class RoutingEngine {
    private long entityId;
    private String name;


    public static IProcessingEntity routePayment(String entityId){
        switch (entityId){
            case "SBI":
                return new SBIBank();
            case "HDFC":
                return new HDFCBank();
            default:
                return null;
        }

    }
    //Routing based on Instrument
    public static IProcessingEntity routePaymentOnInstrument(InstrumentType instrumentType){
        switch (instrumentType){
            case CC:
                return new SBIBank();
            case UPI:
                return new HDFCBank();
            default:
                return null;
        }

    }

    //Routing based on Transaction percentage
    public static IProcessingEntity routePaymentOnPercentage(int count, int totalCount){
        float percent = (count / totalCount)*100;

        if (percent <30)
            return new SBIBank();
        else
            return new HDFCBank();
    }
}
