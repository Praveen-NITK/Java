package org.practice.FLIPKART;
public interface FlipCache{
    public void setEvictionPolicy(EvictionPolicy evp);
    public EvictionPolicy getEvictionPolicy();
}
