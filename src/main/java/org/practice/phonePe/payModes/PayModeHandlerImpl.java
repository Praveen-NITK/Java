package org.practice.phonePe.payModes;

import phonePe.Merchant;
import phonePe.enums.InstrumentType;
import phonePe.onboarding.IOnBoardingHandler;
import phonePe.onboarding.OnBoardingHandlerImpl;

import java.util.LinkedList;
import java.util.List;

public class PayModeHandlerImpl implements IPayModeHandler{

    private static List<InstrumentType> pgSupportedInstruments;
    private static OnBoardingHandlerImpl onBoardingHandler;

    public PayModeHandlerImpl(OnBoardingHandlerImpl onBoardingHandler) {
        this.onBoardingHandler=onBoardingHandler;
        this.pgSupportedInstruments= new LinkedList<>();
    }

    @Override
    public List<InstrumentType> supportedPayModes(Merchant merchant) {
        if(merchant!=null && onBoardingHandler.hasClient(merchant))
            return merchant.getPreferredInstrumentTypes();
        else
            return pgSupportedInstruments;
    }

    @Override
    public void addSupportForPayMode(Merchant merchant, InstrumentType instrumentType) {
        pgSupportedInstruments.add(instrumentType);

        if(merchant!=null && onBoardingHandler.hasClient(merchant))
            merchant.getPreferredInstrumentTypes().add(instrumentType);

    }

    @Override
    public boolean removePayMode(Merchant merchant, InstrumentType instrumentType) {

        if(merchant!=null && onBoardingHandler.hasClient(merchant))
            return merchant.getPreferredInstrumentTypes().remove(instrumentType);
        else
            return pgSupportedInstruments.remove(instrumentType);
    }
}
