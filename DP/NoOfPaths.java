package DP;
public class NoOfPaths{
    public static void main(String[] args) {
        int [][] matrix= new int[500][600];
        //System.out.println(findNoOfPaths(matrix,20,20));
        System.out.println(findNoOfPathsDP(matrix,20,20));
    }

    private static int findNoOfPaths(int[][] matrix,int m, int n) {
        // if(m<0 || n<0)
        //     return 0;
        if(m==0 || n==0)
            return 1;
        return findNoOfPaths(matrix, m-1, n)+findNoOfPaths(matrix, m, n-1);        
    }

    private static int findNoOfPathsDP(int [][]matrix, int m, int n){
        int [][]pathMartix;
        pathMartix=matrix;
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {                
                if(i==0 || j==0)
                    pathMartix[i][j]=1;                
                else
                    pathMartix[i][j]=pathMartix[i-1][j]+pathMartix[i][j-1];
            }            
        }

        return pathMartix[m][n];
    }
}