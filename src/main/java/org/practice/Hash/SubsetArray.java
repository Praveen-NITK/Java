package org.practice.Hash;
import java.util.Arrays;
import java.util.HashSet;


//Question: Find whether an array is a subset of another array
//https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/

public class SubsetArray{
    public static void main(String[] args) {
        int []arr= new int[]{3,6,5};
        int []subArr=new int[]{6,5};
        boolean isSubset;//=isSubsetUsingHashSet(subArr,arr);

        isSubset=isSubsetUsingSortMerge(subArr,arr);
        System.out.println("subArr is subset of arr: "+isSubset);

    }

    private static boolean isSubsetUsingSortMerge(int[] subArr, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(subArr);
        int left=0;
        int right=0;

        while(left<arr.length && right<subArr.length){
            if(arr[left]<subArr[right]){
                left++;
            }
            else if(arr[left]==subArr[right]){
                left++;
                right++;
            }
            else{
                return false;
            }
        }
        if(left==arr.length && right!=subArr.length)
            return false;
        else
            return true;
    }

    private static boolean isSubsetUsingHashSet(int[] subArr, int[] arr) {
        //For handling when arr={1,2,4} and subArr={1,2,4,4}
        if(arr.length<subArr.length){
            return false;
        }
        HashSet<Integer> hSet=new HashSet<>();
        for (Integer var : arr) {
            hSet.add(var);            
        }

        for (Integer var : subArr) {
            if(!hSet.contains(var))
                return false;                       
        }
        return true;
    }
}
