package org.practice.phonePe.payModes;

import org.practice.phonePe.Merchant;
import org.practice.phonePe.enums.InstrumentType;

import java.util.List;

public interface IPayModeHandler {

    public List<InstrumentType> supportedPayModes(Merchant merchant);

    public void addSupportForPayMode(Merchant merchant, InstrumentType instrumentType);

    public boolean removePayMode(Merchant merchant, InstrumentType instrumentType);
}
