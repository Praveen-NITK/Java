//DP: https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
package org.practice.Matrix;
public class MaxSizeSquare{
    static int maxSizedSquareWith1=Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [][]input={ {0,1,1,0,1},
                        {1,1,0,1,0},
                        {0,1,1,1,0},
                        {1,1,1,1,0},
                        {1,1,1,1,1},
                        {0,0,0,0,0}};

        
        getMaxSizedSquare(input);

        System.out.println("Maximum size of square matrix with all 1's is: "+maxSizedSquareWith1);
    }

    private static void getMaxSizedSquare(int[][] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if(input[i][j]==1){
                    //Take min of left, up, and diagonal upLeft element +1
                    int tempMax=Math.min(Math.min(input[i-1][j],input[i][j-1]),input[i-1][j-1])+1;
                    input[i][j]=tempMax;
                    if(tempMax>maxSizedSquareWith1)
                        maxSizedSquareWith1=tempMax;
                }
            }
        }
    }
}