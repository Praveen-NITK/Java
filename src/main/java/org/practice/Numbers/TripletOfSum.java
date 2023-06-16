package org.practice.Numbers;

import java.util.HashSet;
import java.util.Hashtable;

public class TripletOfSum{
    
    public static void main(String[] args) {
        int sum=13;
        int[] arr= new int[]{1,2,4,8,3,5,6,9}; //with unique elements
        printTripletsOfSum(arr,sum,arr.length);
    }

    private static void printTripletsOfSum(int[] arr, int sum, int n) {
        for (int i =n-1 ; i >=0; i--) {
            Hashtable<Integer, Boolean> ht= new Hashtable<>();
            for (int j = 0; j < i; j++) {
                ht.put(arr[j], true); //to make the element visited
            }
            for (int k = 0; k < i; k++) {
                int leftSum=sum-arr[i];              
                //ht.get(arr[k]) -- for unique triplets     
                //(leftSum-arr[k]) != arr[k]) -- for non repeating elements in triplets
                if(ht.containsKey(leftSum-arr[k]) && ht.get(arr[k]) && (leftSum-arr[k]) != arr[k]){
                    ht.put(leftSum-arr[k], false);
                    System.out.println(arr[i]+","+arr[k]+","+(leftSum-arr[k]));
                }
            }
        }
    }
}
