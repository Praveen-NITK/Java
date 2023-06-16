package org.practice.phonePe.onboarding;

import phonePe.Merchant;

public interface IOnBoardingHandler {

    public boolean addClient(Merchant merchant);

    public boolean removeClient(Merchant merchant);

    public boolean hasClient(Merchant merchant);

}
