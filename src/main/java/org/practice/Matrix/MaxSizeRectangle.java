//https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
package org.practice.Matrix;
public class MaxSizeRectangle{
    public static void main(String[] args) {
        int input[][]={{0,1,1,0},
                        {1,1,1,1},
                        {1,1,0,1},
                        {1,1,0,0}};

        int maxArea=getMaxAreaRectangle(input);
        System.out.println(maxArea);
    }

    private static int getMaxAreaRectangle(int[][] input) {
        int result=LargestAreaHistogram.getMaxArea(input[0], input[0].length);
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j]==1)
                    input[i][j]+=input[i-1][j];
            }
            result=Math.max(result, LargestAreaHistogram.getMaxArea(input[i], input[i].length));
        }
        return result;
    }
}