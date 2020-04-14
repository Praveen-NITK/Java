package FLIPKART;
public interface EvictionPolicy{
    //Can be made more generic
    public String EvictionPolicyName="";
    public boolean evictionPolicy(int data); 
    public void displayCache(int pageFaults);
}