package DP;
//https://www.geeksforgeeks.org/coin-change-dp-7/
public class CoinChange{
    public static void main(String[] args) {
        int sum=6;
        int []coins={2,1,3};

        int noOfWays=getNoOfwaysDP(coins,sum);
        //int noOfWays=getNoOfwaysRecursive(coins, coins.length, sum);
        System.out.println(noOfWays);        
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
        if (sum == 0) 
            return 1; 
  
        if (sum < 0) 
            return 0; 

        if (m <=0 && sum >= 1) 
            return 0; 

        // count is sum of solutions (i) excluding coins[m-1] (ii) including coins[m-1] 
        return getNoOfwaysRecursive( coins, m - 1, sum ) + getNoOfwaysRecursive( coins, m, sum-coins[m-1] ); 
    }
}