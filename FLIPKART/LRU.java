package FLIPKART;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRU implements EvictionPolicy{  
    
    static Deque<Integer> dq;
    static HashSet<Integer> hset;
    String EvictionPolicyName;

    static int frameSize;

    LRU(int n){
        frameSize=n;
        dq= new LinkedList<>();
        hset= new HashSet<>();
        EvictionPolicyName="LRU";
    }

    public boolean evictionPolicy(int x){
        boolean isPageFault=false;
        if(!hset.contains(x)){
            if(dq.size()==frameSize){
                int last=dq.removeLast();
                hset.remove(last);
            }
            isPageFault=true;
        }
        else{
            //int index=0, i=0;
            //Iterator<Integer> itr = dq.iterator();
            // while(itr.hasNext()){
            //     if(itr.next()==x){
            //         index=i;
            //         break;
            //     }
            //     i++;
            // }            
            //dq.remove(index);
            dq.removeLastOccurrence(x);
        }
        dq.push(x);
        hset.add(x);
        return isPageFault;    
    }
    public void displayCache(int pageFaults){
        Iterator<Integer> itr = dq.iterator();
            System.out.println("No Of PageFaults with "+EvictionPolicyName +" is: "+pageFaults);
            while(itr.hasNext()){
                System.out.print(itr.next()+" ");
            }
    }
}