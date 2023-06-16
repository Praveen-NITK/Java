package org.practice.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input= {1,4,3,4,5,3};
        int maxIncreasingLength=findLongestIncreasingSubs(input);
        System.out.println(maxIncreasingLength);
    }

    private static int findLongestIncreasingSubs(int[] input) {
        if(input.length==0 || input.length==1)
            return input.length;
        int []dp=new int[input.length];
        Arrays.fill(dp,1);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <input.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(input[j]<input[i])
                    dp[i]=Math.max(dp[j]+1,dp[i]);
            }
            if(dp[i]>max) max=dp[i];
        }
        return max;
    }
}
