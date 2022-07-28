package ArrayPrograms;

import java.util.Arrays;
import java.util.Random;

public class Unique {
    public static void main(String[] args) {
        int []input=new int[10];
        Random rand= new Random(System.currentTimeMillis());
        for (int i = 0; i <10 ; i++) {
            input[i]=rand.nextInt(40);
        }
        System.out.println(Arrays.toString(input));
        boolean isUnique=isUniqueRecursive(input,0,input.length-1);
//        boolean isUnique=isUniqueUsingSort(input);
//        boolean isUnique=isUnique(input);
        System.out.println(isUnique);
    }

    private static boolean isUnique(int[] input) {
        for (int i = 0; i < input.length-1; i++) {
            for (int j = i+1; j <input.length ; j++) {
                if(input[i]==input[j])
                    return false;
            }
        }
        return true;
    }

    //Using sort
    private static boolean isUniqueUsingSort(int[] input) {
        Arrays.sort(input);
        for (int i = 0; i < input.length-1; i++) {
            if(input[i]==input[i+1])
                return false;
        }
        return true;
    }

    //[15, 28, 36, 12, 18, 0, 30, 26, 4, 1]
    //Recursive

    /**
     * As a base case, when n = 1, the elements
     * are trivially unique. For n ≥ 2, the elements are unique if and only if the first n−1
     * elements are unique, the last n−1 items are unique, and the first and last elements
     * are different (as that is the only pair that was not already checked as a subcase).
     */

    //Bad approach O(2^n)
    private static boolean isUniqueRecursive(int []input, int low, int high){
        if(low>=high)
            return true;
        return isUniqueRecursive(input,low,high-1)
                && isUniqueRecursive(input,low+1,high)
                && input[low]!=input[high];
    }
}
