package org.practice.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a series of closed intervals [start, end] ,
 * you should design an algorithm to compute the number of maximum subsets without any overlapping.
 *
 *
 * ① Choosing a interval 'x', which has the earliest ending time among all the current intervals, from the interval set 'intvs'.
 * ② Delete all invervals intersecting with 'x'.
 * ③ Repecting ① and ②, until intvs gets empty. These 'x' selected before are the subsets meeting the conditions.
 */

public class MaxIntervalSelection {
    public static void main(String[] args) {
        int[][] interval= {{2,4},{1,3},{3,4},{5,6}};
        int maxInterval= findMaxNonOverlapInterval(interval);
        System.out.println(maxInterval);
        System.out.println(findDeleteCountInterval(interval));
    }

    private static int findMaxNonOverlapInterval(int[][] interval) {
        if (interval.length==0) return 0;
        Arrays.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int result=1;
        int x_earliest_end =interval[0][1];
        for (int[] elem:interval) {
            int start_time =elem[0];
            //if(start_time>x_earliest_end) { //For min Arrow balloon burst problem.
            if(start_time >= x_earliest_end) {
                result++;
                x_earliest_end =elem[1];
            }
        }
        return result;
    }

    private static int findNonOverlapping(int[][] interval){
        if(interval.length==0) return 0;
        int result=1;
        Arrays.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int x_min=interval[0][1];
        for (int[] elem:interval) {
            if(elem[0]>=x_min){
                result++;
                x_min=elem[1];
            }
        }
        return result;
    }

    /**
     * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     */
    private static int findDeleteCountInterval(int[][] interval) {
        return interval.length-findMaxNonOverlapInterval(interval);
    }

    /**
     * Find minimum arrow shoots to burst all the balloons.
     *
     * It's same to maximum non overlapping interval question
     * If there are n intervals without overlapping at most, then at least n arrows which get throw all the intervals are needed.
     *
     * but only one difference: here same border (end and start) will be considered as overlapping
     */
}
