package DP;
//https://www.geeksforgeeks.org/coin-change-dp-7/

//https://github.com/labuladong/fucking-algorithm/blob/english/dynamic_programming/AnalysisOfDynamicProgramming.md
public class CoinChange{
    public static void main(String[] args) {
        int sum=6;
        int []coins={2,1,3};

        System.out.println(noOfWys(coins,sum));
        System.out.println(getNoOfwaysDP(coins,sum));
        System.out.println(getNoOfwaysRecursive(coins, coins.length, sum));
    }

    private static int getNoOfwaysDP(int[] coins, int sum) {
        int []combination=new int[sum+1];
        combination[0]=1;

        for (int coin : coins) {
            for(int i=1;i<combination.length;i++){
                if(i>=coin)
                    combination[i]+=combination[i-coin];
            }
        }
        return combination[sum];
    }

    private static int getNoOfwaysRecursive(int[] coins, int m, int sum) {
        if(m==0 || sum < 0)
            return 0;
        if(sum==0)
            return 1;
        if(coins[m-1]>sum)
            return getNoOfwaysRecursive(coins, m-1,sum);
        // count is sum of solutions (i) excluding coins[m-1] (ii) including coins[m-1] 
        return getNoOfwaysRecursive( coins, m - 1, sum ) + getNoOfwaysRecursive( coins, m, sum-coins[m-1] ); 
    }

    private static int noOfWys(int[] coins, int sum){
        if(sum==0)
            return 0;
        if( sum<0)
            return -1;
        int result=Integer.MAX_VALUE;
        for (int coin:coins) {
            int subProblems= noOfWys(coins,sum-coin);
            if(subProblems==-1) {
                continue;
            }
            result=Math.min(result,1+subProblems);
        }
        if(result!=0)
            return result;
        else
            return -1;
    }
}