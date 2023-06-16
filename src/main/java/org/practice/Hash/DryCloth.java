package org.practice.Hash;

import java.util.*;

/**
 * The rope is small and all the clothes are not able to be spread out properly,
 *  Clothes are placed on top of other cloth.
 *  So some of the clothes are covered - partially or completely - by the other ones.
 *  Knowing the order and the position in which the clothes were hung, determine how many clothes are visible (partially or completely) when seen from front.
 * Consider the rope was of length N meters divided into N equal sections starting from 0 to N. Each cloth of width P occupies one or more than one section completely. (1<=P<=N & P is a +ve integer).
 * (Note: Ignore the other dimension of cloth for the purpose of this problem)
 */

/**
 * Example
 * Sample input: 10:5:{{0,4},{6,3},{1,5},{6,4},{7,2}}
 * Here 10 is the length of the rope in meters. 5 is the number of clothes hung on rope. The first cloth starts from 0 and covers 4 sections from 0. The second cloth starts at 6 and covers 3 sections from 6 and so on..
 * Sample output: 4
 * The total number of clothes visible when seen from front is 4.
 */
public class DryCloth {
    private static final int ROPE_LENGTH=10;
    private static final int NO_OF_CLOTHS=5;
    public static void main(String[] args) {
//        int [][]input={{0,4},{6,3},{1,5},{6,4},{7,2}};
        int [][]input={{0,3},{0,6},{0,2},{1,7},{0,7}};
        int visibilityCount= countVisibility(input);
        System.out.println(visibilityCount);
    }

    private static int countVisibility(int[][] input) {
        Map<Integer, Integer> visibility = new HashMap<>();
        for(int i=0;i<NO_OF_CLOTHS;i++) {
            if(input[i][0]>=0 && input[i][0]+input[i][1]<ROPE_LENGTH)
                for (int j = input[i][0]; j <= input[i][0] + input[i][1]; j++) {
                    visibility.put(j, i);
                }
        }
        Set<Integer> clothesRemaining = new HashSet<>();
        for(int key : visibility.keySet()) {
            clothesRemaining.add(visibility.get(key));
        }
        return clothesRemaining.size();
    }
}
