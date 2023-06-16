package org.practice.Recursion;

import java.util.Arrays;

public class BubbleSortRecursive {
    public static void main(String[] args) {
        int []input= {7,5,2,4,1,12,9};
        sortRecursive(input, input.length);
        System.out.println(Arrays.toString(input));
    }
    //after every pass max element moves to last position
    // i.e 5,2,4,1,7,9,12 and then we need to sort first n-1 numbers(5,2,4,1,7,9) same way
    // can be treated as same problem
    private static void sortRecursive(int[] input, int n) {
        if(n<=0)
            return;
        for (int i = 0; i <n-1 ; i++) {
            if(input[i]>input[i+1])
                swapElements(input, i);
        }
        sortRecursive(input, n-1);
    }

    private static void swapElements(int[] input, int i) {
        int temp=input[i];
        input[i]=input[i+1];
        input[i+1]=temp;
    }
}
