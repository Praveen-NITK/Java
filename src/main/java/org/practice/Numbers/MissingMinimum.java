package org.practice.Numbers;

import java.util.Arrays;
//https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/

public class MissingMinimum {
    public static void main(String[] args) {
        int []A={-10,-20,0,2,10};
        int result= findMissingMin(A);

        System.out.println(result);
    }

    //Might not be feasible for all test cases
    private static int findMissingMin(int[] A) {
        if(A.length==0)
            return 1;
        Arrays.sort(A);
        int missing_min=A[A.length-1];
        for(int i=0;i<A.length-1;i++){
            if(A[i]>=0 && A[i+1]-A[i]>1){
                if( A[i]+1>0)
                    return A[i]+1;
            }
        }
        return missing_min<0?1:missing_min+1;
    }
}
