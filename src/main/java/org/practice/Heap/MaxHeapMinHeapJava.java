package org.practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * MinHeap keeps smallest element on top for removal i.e maintains largest element is heap
 * Opposite for MaxHeap
 */
public class MaxHeapMinHeapJava {
    public static void main(String[] args) {
        int[] input={3,4,1,6,2,7};
        int CAPACITY=3;

        PriorityQueue<Integer> minHeap= new PriorityQueue<>(CAPACITY);

        for (int i:input) {
            if(minHeap.size()>=CAPACITY && minHeap.peek()<i){
                System.out.println("min removed for: "+i+"   "+minHeap.poll());
                minHeap.add(i);
            }
            else if(minHeap.size()<CAPACITY){
                minHeap.add(i);
            }

        }
        //print n largest
        System.out.println(minHeap);


        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(CAPACITY, Collections.reverseOrder());

        for (int i:input) {
            if(maxHeap.size()>=CAPACITY && maxHeap.peek()>i){
                System.out.println("removed for: "+i+"   "+maxHeap.poll());
                maxHeap.add(i);
            }
            else if(maxHeap.size()<CAPACITY){
                maxHeap.add(i);
            }
        }
        //print n smallest
        System.out.println(maxHeap);
    }
}
