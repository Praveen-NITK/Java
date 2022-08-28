package DP;

import java.util.Arrays;

/**
 * at least  how many COINS are needed to scrape up this amount, if it is impossible, the algorithm returns -1.
 */
public class MinCoinChange {
    static  int[] coins={2,3,5};

    public static void main(String[] args) {
        System.out.println(getMinCoinChanges(11));
    }
    private static int getMinCoinChanges( int sum) {
        if(sum < 0) return -1;
        if(sum==0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblems = getMinCoinChanges(sum - coin);
            if (subProblems == -1) continue;
            res= Math.min(res,1+subProblems);
        }
        return res!=Integer.MAX_VALUE?res:-1;
    }
}
