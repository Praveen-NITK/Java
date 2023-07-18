package org.practice.Recursion;

public class CheckIfStrictlyIncreasing {
    public static void main(String[] args) {
        int []input={5,2,3,6,7};
        boolean isSorted=checkifSorted(input,0);
        System.out.println(isSorted);
    }

    private static boolean checkifSorted(int[] input, int index) {
        if(index==input.length-1)
            return true;

        if(input[index]<input[index+1])
            return checkifSorted(input,index+1);
        else
            return false;
    }
}
