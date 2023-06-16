package org.practice.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public static void main(String[] args) {
//        int [] input={1,3,-1,-3,5,3,6,7};
        int [] input={1,-1};
        int windowSize=1;
        int []result= maxSlidingWindow(input,windowSize);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(k, Collections.reverseOrder());
        // for(int i=0;i<k;i++) {
        //     pq.add(nums[i]);
        // }
        ArrayList<Integer> output= new ArrayList<>(nums.length-k+1);
        for(int i=0;i<nums.length;i++) {
            pq.add(nums[i]);
            int top=0;
            if(pq.size()>=k) {
                top=pq.peek();
                output.add(pq.peek());
            }
            while (pq.size()>k)
                pq.poll();
            pq.add(top);

        }
        return output.stream().mapToInt(i -> i).toArray();
    }
}
