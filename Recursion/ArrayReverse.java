package Recursion;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int []input= {1,2,3,4};
        System.out.println(Arrays.toString(input));
        reverseArrayRecursive(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
    }

    private static void reverseArrayRecursive(int[] input, int low, int high) {
        if(low<high){
            int temp=input[low];
            input[low]=input[high];
            input[high]=temp;

            reverseArrayRecursive(input,low+1,high-1);
        }
    }
}
