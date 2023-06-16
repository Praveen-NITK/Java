//https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
package org.practice.DP;
//calculate the minimum number of attempts and find out the floor where the eggs just won’t be broken.
//https://labuladong.gitbook.io/algo-en/i.-dynamic-programming/throwingeggsinhighbuildings
public class EggDrop{
    public static void main(String[] args) {
        int minNoOfTrials=getMinNoOfTrials(2,10);
        System.out.println(minNoOfTrials);
        System.out.println(minNoOfTrialDP(2,10));
    }

    private static int getMinNoOfTrials(int eggs, int floors) {
        if(eggs==1){
            return floors;
        }
        if(floors==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < floors; i++) {       
            //At any time at floor i 
            //if egg breaks-->remaining no of floors to compute=i-1 with e-1 
            //else if egg not breaks --> remaining no of floors to compute is n-i with e eggs

            min= Math.min(min,
                    Math.max(getMinNoOfTrials(eggs-1,i-1),
                            getMinNoOfTrials(eggs,floors-i)
                    )); // throw once on the i-th floor
        }
        return min+1;
    }
    private static int minNoOfTrialDP(int eggs, int floors){
        int [][]dp=new int[floors+1][eggs+1];
        for (int i = 0; i <= floors; i++) {
            dp[i][0]=i;
        }
        for (int j = 1; j <= eggs; j++) {
            dp[0][j]=1;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            for (int j = 1; j <= eggs; j++) {
                dp[i][j]=Math.min(min,
                        Math.max(dp[i-1][j-1],
                                dp[i-1][j]
                        ));
            }
        }
        return dp[floors][eggs]+1;
    }
}