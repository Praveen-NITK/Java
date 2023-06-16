package org.practice.DP;
public class TrainsBwStations{
    public static void main(String[] args) {
        int [][]costMatrix=new int[][]{{0,10,75,94},
                                        {-1,0,35,50},
                                        {-1,-1,0,80},
                                        {-1,-1,-1,0}};

        int minCost= minCost(0,3, costMatrix);
        System.out.println(minCost);

    }

    private static int minCost(int src, int dest, int [][]cost) {
        if(src==dest){
            return cost[src][dest];
        }
        int min=cost[src][dest];
        for(int i=src+1;i<dest;i++){
            //Via i
            int temp=minCost(src, i, cost)+minCost(i, dest, cost);
            min=Math.min(min, temp);
        }        
        return min;
    }
}
