package org.practice.DP;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
public class MinLengthUnsortedSubArray{
    public static void main(String[] args) {
        int[] input={10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int minLength= getMinLengthUnsortedSubArray(input);
        System.out.println("Min length of unsorted sub array is: "+minLength);
    }

    private static int getMinLengthUnsortedSubArray(int[] input) {
        int subArrStartIndex=0;
        int subArrayEndIndex=input.length-1;
        for (int i = 0; i < input.length; i++) {
            if(input[i]>input[i+1])
                subArrStartIndex=i;            
        }
        for (int i = input.length-1; i >= 0; i--) {
            if(input[i]<input[i-1])
                subArrayEndIndex=i;
        }
        //Arrays.sort(Arrays.asList(input).subList(subArrStartIndex, subArrayEndIndex).toArray());
        //if
        return 0;
    }
}
