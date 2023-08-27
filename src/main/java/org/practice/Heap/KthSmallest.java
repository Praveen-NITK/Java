package org.practice.Heap;

import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int []input = {2,4,1,5,8};
        int k=2;
        int largest=findKthLargest(input,k);
        System.out.println(largest);
    }
    private static int findKthLargest(int []input, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>((p1,p2)->p2-p1);
        for (int val:input) {
            pq.add(val);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}
