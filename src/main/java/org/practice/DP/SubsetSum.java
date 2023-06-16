package org.practice.DP;
public class SubsetSum{
    public static void main(String[] args) {
        int []input= new int[]{3,2,7,2};
        int sum=12;
        System.out.println(isSubsetOfSumExist(sum,input, input.length));
    }

    private static boolean isSubsetOfSumExist(int sum, int[] input, int length) {
        if(sum==0)
            return true;
        if(length==0)
            return false;
        if(input[length-1]>sum)
            return isSubsetOfSumExist(sum, input, length-1);       
        return isSubsetOfSumExist(sum-input[length-1], input, length-1) || isSubsetOfSumExist(sum, input, length-1);
    }
}
