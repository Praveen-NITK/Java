package org.practice.DP;

//https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/solutions/794677/java-solution-top-down-dp/

/**
 * There are n oranges in the kitchen and you decided to eat some of these oranges every day as follows:
 *
 * Eat one orange.
 * If the number of remaining oranges n is divisible by 2 then you can eat n / 2 oranges.
 * If the number of remaining oranges n is divisible by 3 then you can eat 2 * (n / 3) oranges.
 * You can only choose one of the actions per day.
 *
 * Given the integer n, return the minimum number of days to eat n oranges.
 */
public class MinDayEatOranges {
    static int []dp;
    public static void main(String[] args) {
        int n=10;
        dp=new int[n+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i]=-1;
        }

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=2;

        int result= findMinDayToEatOrangesDp(n);
        int resultRecursive= findMinDayToEatOrangesRecursive(n);
        System.out.println(result);
        System.out.println(resultRecursive);

    }

    private static int findMinDayToEatOrangesRecursive(int n) {
        int minDays;

        if(dp[n]!=-1)
            return dp[n];

        if(n <= 0)
            return 0;
        if(n%6==0)
            minDays=1+Math.min(findMinDayToEatOrangesRecursive(n/2), findMinDayToEatOrangesRecursive(n/3));
        else if(n%3==0)
            minDays=1+Math.min(findMinDayToEatOrangesRecursive(n-1), findMinDayToEatOrangesRecursive(n/3));
        else if(n%2==0)
            minDays=1+Math.min(findMinDayToEatOrangesRecursive(n-1), findMinDayToEatOrangesRecursive(n/2));
        else
            minDays=1+ findMinDayToEatOrangesRecursive(n-1);
        dp[n]= minDays;
        return dp[n];
    }

    private static int findMinDayToEatOrangesDp(int n) {
        for (int i = 4; i<=n; i++) {
            if(i%6==0){
                dp[i]=1+Math.min(dp[i/2],dp[i/3]);
            }
            else if(i%3==0){
                dp[i]=1+Math.min(dp[i/3],dp[i-1]);
            }
            else if(i%2==0){
                dp[i]=1+Math.min(dp[i/2],dp[i-1]);
            }
            else
                dp[i]=1+dp[i-1];
        }
        return dp[n];
    }
}
