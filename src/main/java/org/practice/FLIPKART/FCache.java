package org.practice.FLIPKART;

public class FCache implements FlipCache{
    public EvictionPolicy evcp;    
    
    public void setEvictionPolicy(EvictionPolicy e){
        this.evcp=e;
    }    

    public EvictionPolicy getEvictionPolicy(){
        return evcp;
    }
}
