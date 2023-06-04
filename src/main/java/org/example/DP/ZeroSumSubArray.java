package DP;

import java.util.HashMap;

//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
//Maximum length with sum zero.
public class ZeroSumSubArray{
    public static void main(String[] args) {
        int[] input={1,5,-2,2,-8,-1,3,6,-5,23};
        //int reqSum=0;
        int reqSum=0;
        int subsLength= getInputSubstringLength(input, reqSum);
        int subsLengths=getInputSubstringLengthWithHash(input, reqSum);
        System.out.println("Max length subarray with sum: "+reqSum+" is: "+subsLength);
        System.out.println("Max length subarray with sum: "+reqSum+" is: "+subsLengths);
    }

    private static int getInputSubstringLengthWithHash(int[] input, int reqSum) {
        HashMap<Integer,Integer> hmap= new HashMap<>();
        int maxlen=0;
        int sumSofar=0;
        hmap.put(0, 0);
        for (int i = 0; i < input.length; i++) {
            sumSofar+=input[i];
            if(!hmap.containsKey(sumSofar)){
                hmap.put(sumSofar, i);
            }
            else{
                maxlen=Math.max(maxlen, i-hmap.get(sumSofar));
            }
        }
        return maxlen;
    }

    private static int getInputSubstringLength(int[] input, int reqSum) {
        int maxLength=0;
        int tempSum=0;
        for (int i = 0; i < input.length; i++) {
            tempSum=0;
            for (int j = i; j < input.length; j++) {
                tempSum+=input[j];
                if(tempSum==reqSum && j-i+1>maxLength)
                    maxLength=j-i+1;                    
            }            
        }
        return maxLength;
    }
}