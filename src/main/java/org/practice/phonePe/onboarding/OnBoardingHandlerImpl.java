package org.practice.phonePe.onboarding;

import org.practice.phonePe.Merchant;

import java.util.LinkedList;
import java.util.List;

/**
 * MerchantOnBoarding is a Singleton class
 */
public class OnBoardingHandlerImpl implements IOnBoardingHandler {

    private static List<Merchant> onBoardedMerchants;
    private static OnBoardingHandlerImpl onBoardingInstance= new OnBoardingHandlerImpl();

    private OnBoardingHandlerImpl() {
        onBoardedMerchants=new LinkedList<>();
    }

    public static OnBoardingHandlerImpl getMerchantOnBoardingInstance(){
        return onBoardingInstance;
    }

    @Override
    public boolean addClient(Merchant merchant) {
        try {
            getMerchantOnBoardingInstance().onBoardedMerchants.add(merchant);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean removeClient(Merchant merchant) {
        try {
            getMerchantOnBoardingInstance().onBoardedMerchants.remove(merchant);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean hasClient(Merchant merchant) {
        if(onBoardedMerchants.contains(merchant))
            return true;
        else
            return false;

    }
}
