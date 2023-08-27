package org.practice.Sortings;

import java.util.Arrays;

public class HeapSortWithImplementation {
    int N;
    int [] heap;
    public HeapSortWithImplementation(int capacity){
        heap= new int[capacity];
    }
    private void buildAndSort(int element){
        if(N> heap.length)
            throw new RuntimeException("Extra elements");
        heap[N]=element;
        heapifyUp(N);
        N++;
    }

    private void heapifyUp(int position) {
        while(position/2>=0 && heap[position]>heap[position/2]){
            int temp=heap[position];
            heap[position]=heap[position/2];
            heap[position/2]=temp;
            position=position/2;
        }
    }

    public static void main(String[] args) {
        int []input={3,2,5,7,4,0};
        HeapSortWithImplementation hp= new HeapSortWithImplementation(input.length);
        for (int number:input) {
            hp.buildAndSort(number);
        }
        System.out.println(Arrays.toString(hp.heap));
    }
}
