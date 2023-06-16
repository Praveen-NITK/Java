package org.practice.DP;
//https://www.youtube.com/watch?v=sSno9rV8Rhg

public class LongestCommonSubsequence{
    public static void main(String[] args) {
        String first="ABCDE";
        String second="CBDEFG";
        //int result= getMaxCommonSubsequence(first,second, first.length(),second.length());
        //int resultMem= getLCSMemoized(first,second, first.length(),second.length());
        int resultDP= getLCS_DP(first,second, first.length(),second.length());
//        System.out.println(result);
//        System.out.println(resultMem);
        System.out.println(resultDP);
    }

    //Recursive O(2^n) -Exponential
    private static int getMaxCommonSubsequence(String first, String second, int m, int n) {
        if(m==0 || n==0)
            return 0;
        if(first.charAt(m-1)==second.charAt(n-1))
            return 1+getMaxCommonSubsequence(first, second, m-1, n-1);
        return Math.max(getMaxCommonSubsequence(first, second, m, n-1), getMaxCommonSubsequence(first, second, m-1, n));
    }

    //Memoized O(m*n) -polynomial
    private static int getLCSMemoized(String first, String second, int m, int n){
        int mem[][]= new int[m+1][n+1];
        if(m==0 || n==0) {
            mem[m][n] = 0;
            //return mem[m][n];
        }
        if(mem[m][n]!=0)
            return mem[m][n];
        if(first.charAt(m-1)==second.charAt(n-1))
            mem[m][n]=1+getLCSMemoized(first, second, m-1, n-1);
        else
            mem[m][n]=Math.max(getLCSMemoized(first, second, m, n-1), getLCSMemoized(first, second, m-1, n));
        return mem[m][n];
    }

    private static int getLCS_DP(String first, String second, int m, int n){
        int lcs[][]= new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0)
                    lcs[i][j]=0;
                else if(first.charAt(i-1)==second.charAt(j-1))
                    lcs[i][j]=1+ lcs[i-1][j-1];
                else
                    lcs[i][j]=Math.max(lcs[i][j-1], lcs[i-1][j]);
            }
        }

        return lcs[m][n];
    }
}
