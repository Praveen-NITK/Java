package org.practice.FLIPKART;

import java.util.ArrayList;

public class CacheData implements FlipCacheLibrary{
    private ArrayList<FlipCache> flipCaches;    
    
    public CacheData(){
        flipCaches=new ArrayList<>();
    }

    //Registers New Caches to FlipCacheLibrary
    public void registerCache(FlipCache flpc){
        flipCaches.add(flpc);
    }
    
    //Remove Any Faulty Cache from FlipCacheLibrary
    public void removeCache(FlipCache flpc){
        if(flipCaches.contains(flpc))
            flipCaches.remove(flpc);
    }

}
