package org.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

//Find All subsets of first n natural numbers
public class AllSubsets {
    public static void main(String[] args) {
        int n=3;
        List<Integer> subsetList=new ArrayList<>();
        findSubset(n, subsetList);
    }

    private static void findSubset(int n, List<Integer> subsetList) {
        if(n==0){
            printSubsetList(subsetList);
            return;
        }
        //If element is coming into subset
        subsetList.add(n);
        findSubset(n-1, subsetList);

        //If element is not coming into subset
        subsetList.remove(subsetList.size()-1);
        findSubset(n-1,subsetList);


    }

    private static void printSubsetList(List<Integer> subsetList) {
        for (Integer data:subsetList) {
            System.out.print(data+" ");
        }
        System.out.println();
    }
}
