package org.practice.DP;
public class MaxSumSubArray{
    public static void main(String[] args) {        
        int []input= new int[]{-2,-3,4,-1,2,-3,5,-2,1};
//        System.out.println(getMaximumSumSubArrayBF(input));
//
//        System.out.println(getMaximumSumSubArray(input));
//        System.out.println(getMaximumSumSubArrayRecursive(input,input.length-1));
        printIndex(input);
    }

    private static int getMaximumSumSubArrayBF(int[] input) {
        int max=0;
        int tempSum=0;
        for(int i=0;i<input.length;i++)
        {
            tempSum=input[i];
            for(int j=i+1;j<input.length;j++)
            {
                tempSum+=input[j];
                if(tempSum>max)
                    max=tempSum;
            }
        }        
        return max;
    }

    private static int getMaximumSumSubArray(int[] input) {
        int maxSumSoFar=0, maxSumEndingHere=0;
        for(int i=0;i<input.length;i++){
            maxSumEndingHere+=input[i];
            if(maxSumEndingHere<0)
                maxSumEndingHere=0;
            else if(maxSumSoFar<maxSumEndingHere)
                maxSumSoFar=maxSumEndingHere;
        }
        return maxSumSoFar;
    }

    private static void printIndex(int []input){
        int tempSum=0;
        int maxSum=0;
        int start=0;
        int end=0;
        for (int i = 0; i < input.length; i++) {
            tempSum=input[i];
            for (int j = i+1; j <input.length ; j++) {
                tempSum+=input[j];
                if(tempSum>maxSum){
                    maxSum=tempSum;
                    start=i;
                    end=j;
                }
            }
        }
        System.out.println(maxSum);
        System.out.println("index:"+start+"to"+end);
    }

    //Non working
    private static int getMaximumSumSubArrayRecursive(int[] input, int n){
        if(n==0)
            return Math.max(input[n],0);
        
        return Math.max(getMaximumSumSubArrayRecursive(input, n-1)+ input[n],input[n]);
    }
}
