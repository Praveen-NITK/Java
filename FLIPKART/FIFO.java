package FLIPKART;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FIFO implements EvictionPolicy{
    Deque frameQ;
    String EvictionPolicyName;

    static int frameSize;

    FIFO(int n){
        frameSize=n;
        frameQ= new LinkedList<Integer>();
        EvictionPolicyName="FIFO";
    }

    public boolean evictionPolicy(int x){
        boolean isPageFault=false;
        if(!frameQ.contains(x)){
            if(frameQ.size()==frameSize){
                frameQ.removeFirst();                
            }            
            frameQ.addLast(x);
            
            isPageFault=true;
        }        
        return isPageFault;    
    }
    public void displayCache(int pageFaults){
        Iterator<Integer> itr = frameQ.iterator();
            System.out.println("No Of PageFaults with "+EvictionPolicyName +" is: "+pageFaults);
            while(itr.hasNext()){
                System.out.print(itr.next()+" ");
            }
            System.out.println();
    }

}
