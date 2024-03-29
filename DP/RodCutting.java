package DP;
//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class RodCutting{
    public static void main(String[] args) {   
        int[] priceOfPieces={1,5,8,9,10,17,17,20};
        int maxProfit=getMaxProfit(priceOfPieces, priceOfPieces.length);
        int maxProfits=getMaxProfitDP(priceOfPieces, priceOfPieces.length);
        System.out.println(maxProfit);
        System.out.println(maxProfits);

        
    }

    

    private static int getMaxProfitDP(int[] priceOfPieces, int n) {
        int []val= new int[n+1];
        val[0]=0;
        for (int i = 1; i <= n; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max=Math.max(max, priceOfPieces[j]+val[i-j-1]);
            }
            val[i]=max;
        }
        return val[n];
    }

    private static int getMaxProfit(int[] priceOfPieces, int n) {
        if(n<=0)
            return 0;
        
        int max=Integer.MIN_VALUE; 
        for (int i = 0; i < n; i++) {
            max=Math.max(max, priceOfPieces[i]+getMaxProfit(priceOfPieces, n-i-1));
        }
        return max;
    }
}