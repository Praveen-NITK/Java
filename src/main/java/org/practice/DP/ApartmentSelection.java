package DP;

import java.util.Arrays;

// -------------
public class ApartmentSelection {
    public static void main(String[] args) {
        int [][]input={{1,1,0},{0,0,1}};
        int n = input.length;
        int m = input[0].length;
        int[][]dp= new int[n][m+1];
        int result=0;
        for (int j = 0; j < n; j++) {
            Arrays.fill(dp[j],Integer.MAX_VALUE);
            dp[j][m]=0;
        }
        for (int j = 0; j < m; j++) {
            if(input[0][j]==1)
                dp[0][j]=0;
            dp[0][m]=Math.max(0,dp[0][j]);
        }
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j]=dp[i-1][j]!=Integer.MAX_VALUE?dp[i-1][j]+1:Integer.MAX_VALUE;
                if(input[i][j]==1)
                    dp[i][j]=0;
                dp[i][m]=Math.max(0,dp[i][j]);
            }
        }
        for (int i = n-2; i >0 ; i--) {
            for (int j = m-1; j >=0; j--) {
                dp[i][j]=Math.min(dp[i][j],dp[i+1][j]+1);
                if(input[i][j]==1)
                    dp[i][j]=0;
                dp[i][m]=Math.max(dp[i][m],dp[i][j]);
            }
        }
        int min= dp[0][m];
        for (int i = 1; i < n; i++) {
            if(dp[i][m]<min) {
                min = dp[i][m];
                result=i;
            }
        }
        System.out.println(result);
    }

}
