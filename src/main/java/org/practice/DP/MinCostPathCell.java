package org.practice.DP;
//Movement allowed only right and down.
public class MinCostPathCell{
    static int [][]Mem= new int[3][4];
    public static void main(String[] args) {
        int [][]cost={  {1,3,5,8},
                        {4,2,1,7},
                        {4,3,2,3}
                    };

        System.out.println(findMinCost(cost,2,3));
        System.out.println(findMinCostMemoized(cost,2,3));
        System.out.println(findMinCostDP(cost,2,3));

    }
    //Non Memoized recursive O(2^n) exponential
    private static int findMinCost(int[][] cost, int row, int col) {
        if(row==0 && col==0)
            return cost[0][0];
        if(row==0)
            return findMinCost(cost,0,col-1)+cost[row][col];
        if(col==0)
            return findMinCost(cost,row-1,0)+cost[row][col];
        return Math.min(findMinCost(cost,row-1,col),findMinCost(cost, row, col-1))+cost[row][col];
    }

    //Memoized recursive O(2^n) exponential
    private static int findMinCostMemoized(int[][] cost, int row, int col) {
        if(Mem[row][col]!=0){
            return Mem[row][col];
        }
        
        if(row==0 && col==0)
            return cost[0][0];
        else if(row==0 )
            Mem[row][col]= findMinCost(cost,0,col-1)+cost[row][col];
        else if(col==0 )
            Mem[row][col]=findMinCost(cost,row-1,0)+cost[row][col];
        else
            Mem[row][col]= Math.min(findMinCost(cost,row-1,col),findMinCost(cost, row, col-1))+cost[row][col];
        
        return Mem[row][col];
    }

    //O(n^2)
    private static int findMinCostDP(int[][] cost,int row, int col){
        //int [][]clone=cost;
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                if(i==0 && j==0)
                    continue;
                if(i==0 && j!=0)
                    cost[i][j]+=cost[i][j-1];
                else if(j==0 && i!=0)
                    cost[i][j]+=cost[i-1][j];
                else
                    cost[i][j]+=Math.min(cost[i][j-1],cost[i-1][j]);
            }
        }
        return cost[row][col];
    }
}
