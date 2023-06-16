package org.practice.MustDo.Google;
//find if contiguous sub array exist with given sum
//https://www.geeksforgeeks.org/must-coding-questions-company-wise/#google
public class SumSubArray{
    public static void main(String[] args) {
        int []input={1,2,3,7,5,8};
        //printSubsets(input);
        int sum=12;
        //printSubArrayOfSumNaive(sum, input);
        printSubArrayOfSumDP(sum, input);
    }

    //Self written
    private static void printSubArrayOfSumDP(int sum, int[] input) {
        int tempSum=sum;
        int j=input.length-1;
        for (int i = j; i >=-1; i--) {
            if(sum==0){
                System.out.println(++i+" "+j);
                return;
            }
            if(input[i]<=sum){
                sum-=input[i];
            }
            else{
                i=j--;
                sum=tempSum;
            }            
        }
    }

    // Naive Approach
    private static void printSubArrayOfSumNaive(int sum, int[] input) {
        for (int i = 0; i < input.length; i++) {
            int tempSum=0;
            tempSum+=input[i];
            for (int j = i+1; j < input.length; j++) {
                tempSum+=input[j];
                if(tempSum<sum){
                    continue;
                }
                else if(tempSum==sum){
                    System.out.println(i+" "+j);
                    return;
                }
                // else{
                //     break;
                // }
            }
        }
        System.out.println("No such subArray exists");
    }

    //https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
    static void printSubsets(int set[]) 
    { 
        int n = set.length; 
  
        // Run a loop for printing all 2^n 
        // subsets one by one .... n times leftshift of 1 ==64
        for (int i = 0; i < (1<<n); i++) 
        { 
            System.out.print("{ "); 
  
            // Print current subset 
            for (int j = 0; j < n; j++) 
  
                // (1<<j) is a number with jth bit 1 
                // so when we 'and' them with the 
                // subset number we get which numbers 
                // are present in the subset and which 
                // are not 
                if ((i & (1 << j)) > 0) 
                    System.out.print(set[j] + " "); 
  
            System.out.println("}"); 
        }
    }
}
