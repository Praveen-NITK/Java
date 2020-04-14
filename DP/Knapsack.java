package DP;
//https://www.geeksforgeeks.org/printing-items-01-knapsack/ ==>chexk this too
//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
import java.util.Arrays;

public class Knapsack{
    public static void main(String[] args) {
        int[] wt=new int[]{5,8,10};
        int[] val=new int[]{10,20,30};
        int W=15;
        int n=val.length;
        //int maxProfit=maximizeProfitRecursive(W,wt,val,n);
        int maxProfDP= maximizeProfitDP(W, wt, val, n);
        //System.out.println("maximum profit is: "+maxProfit);
        System.out.println("Maximum profit through DP: "+maxProfDP);
    }

  
    private static int maximizeProfitDP(int W, int[] wt, int[] val, int n) {
        int[][] aux= new int[n+1][W+1];
        //Arrays.fill(aux, 0);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if(i==0||j==0)
                    aux[i][j]=0;
                else if(wt[i-1]<=j){ //if last value is being taken or discarded
                    aux[i][j]=Math.max(val[i-1]+aux[i-1][j-wt[i-1]], aux[i-1][j]);
                }
                else 
                    aux[i][j]=aux[i-1][j];
            }
        }
        return aux[n][W];
    }

    private static int maximizeProfitRecursive(int W, int[] wt, int[] val, int n) {
        if(n==0||W<=0)
            return 0;
        if(wt[n-1]>W)
            return maximizeProfitRecursive(W, wt, val, n-1);
        else{
            return Math.max(val[n-1]+maximizeProfitRecursive(W-wt[n-1], wt, val, n-1), maximizeProfitRecursive(W, wt, val, n-1));
        }
    }
}