package org.practice.Heap;
public class SortingUsingHeap{
    public static void main(String[] args) {
        int []input= {2,7,12,8,5,13,14};
        sortUsingHeap(input);
        for (int i : input) {
            System.out.println(i);
        }
    }

    protected static void sortUsingHeap(int[] input) {
        int n= input.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(input,n,i);
        }

        for(int i=n-1;i>=0;i--){
            int temp=input[0];
            input[0]=input[i];
            input[i]=temp;

            heapify(input, i, 0);
        }

    }

    private static void heapify(int[] input, int n, int i) {
        int largest=i;
        int left=i*2+1;
        int right=i*2+2;

        if(left<n && input[left]>input[largest])
            largest=left;
        if(right<n && input[right]>input[largest])
            largest=right;
        if(largest!=i){
            int temp=input[i];
            input[i]=input[largest];
            input[largest]=temp;

            heapify(input, n, largest);
        }
    }
}
