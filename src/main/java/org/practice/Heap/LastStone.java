//https://medium.com/algorithm-and-datastructure/last-stone-weight-dbc948aab8a
////No Broker dot com
package org.practice.Heap;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {
    public static void main(String[] args) {
        int []stones={1,2,3,4,6,7,7};
        int result= lastStoneWeight(stones);
        System.out.println(result);
    }
    public static int lastStoneWeight(int[] stones) {
        if(stones==null)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while (pq.size() > 1) {
            int first = pq.poll();   //largest
            int second = pq.poll();     //second largest
            if (first != second) {
                int rem = Math.abs(first - second);
                pq.offer(rem);
            }
        }
        return pq.size()==1 ? pq.poll() : 0;
    }
}