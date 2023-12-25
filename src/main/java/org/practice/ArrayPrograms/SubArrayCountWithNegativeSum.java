package org.practice.ArrayPrograms;
//Print the number of subarrays of  having negative sums.
//https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true
public class SubArrayCountWithNegativeSum {
    public static void main(String[] args) {
        int[] input={1,-2,4,-5,1};
        int n= input.length;
        int count=0;
        //set start index of sub array
        for (int i = 0; i < n; i++) {
            // set end index
            for (int j = i; j < n; j++) {
                int sum=0;
                for (int k = i; k <=j ; k++) {
                    sum+=input[k];
                }
                if(sum<0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
