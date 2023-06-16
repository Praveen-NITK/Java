package org.practice.BackTracking;
public class TSPTest{
    public static void main(String[] args) {
        int n=4;
        int [][]graph={{0,10,15,20},
                        {5,0,9,10},
                        {6,3,0,12},
                        {8,8,9,0}};
        boolean []visited=new boolean[n];
        int minCost=Integer.MAX_VALUE;
        minCost=getMinCost(graph,visited,0,n,1,0,minCost);
        System.out.println(minCost);
    }

    private static int getMinCost(int[][] graph, boolean[] visited, int currentPos, int n, int count, int cost, int minCost) {
        visited[currentPos]=true;
        if(count==n && graph[currentPos][0]>0){
            minCost=Math.min(minCost, cost+graph[currentPos][0]);
            return minCost;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i] && graph[currentPos][i]>0){
                minCost=getMinCost(graph, visited, i, n, count+1, cost+graph[currentPos][i], minCost);
                visited[i]=false;
            }
        }
        return minCost;
    }
}
