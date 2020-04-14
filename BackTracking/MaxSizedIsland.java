package BackTracking;

import java.util.Arrays;
//https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
//Either Connected Horizontally Vertically or diagonally
public class MaxSizedIsland{
    static final int N=5;
    static int maxCount=0;
    private static boolean isSafePosition(int x, int y, int[][] input, boolean[][] visited){
        return x>=0 && x<N && y>=0 && y<N && !visited[x][y] && input[x][y]==1;
    }
    public static void main(String[] args) {
        int[][] input= {{1,0,0,0,1},
                        {0,1,0,0,1},
                        {0,1,0,0,1},
                        {1,0,0,0,0},
                        {1,0,1,0,1}};
        int maxSizedIsland= getMaximumSizedIsland(input);
        System.out.println("Max sized island is: "+maxSizedIsland);
    }

    private static int getMaximumSizedIsland(int[][] input) {
        boolean[][] visited=new boolean[5][5];       
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if(input[i][j]==1 && !visited[i][j]){
                    DFSUtility(i,j,input,visited,1);                      
                }
            }
        }
        return maxCount;
    }

    private static void DFSUtility(int x, int y,int[][] input, boolean[][] visited,int count) {         
        visited[x][y]=true;
        int[] x_cor={1,1,0,0,-1,-1,1,-1};
        int[] y_cor={0,1,1,-1,0,1,-1,-1};

        for (int k = 0; k < y_cor.length; k++) {
            if(isSafePosition(x+x_cor[k], y+y_cor[k], input,visited)){                
                DFSUtility(x+x_cor[k], y+y_cor[k], input, visited, ++count);
                maxCount=Math.max(count, maxCount);
            }
        }
        //return count;
    }
}