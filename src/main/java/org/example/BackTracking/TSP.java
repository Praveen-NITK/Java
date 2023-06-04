package BackTracking;
//https://www.geeksforgeeks.org/travelling-salesman-problem-implementation-using-backtracking/
public class TSP{
    public static void main(String[] args) {
        int n=4;
        int [][]graph={{0,10,15,20},
                        {5,0,9,10},
                        {6,3,0,12},
                        {8,8,9,0}};
        boolean []visited= new boolean[n];
        //visited[0]=true;
        int minimumCost=Integer.MAX_VALUE;
        minimumCost= TSPUtil(graph,visited,0,n,1,0,minimumCost);
        System.out.println("Min cost of TSP: "+minimumCost);
    }

    private static int TSPUtil(int[][] graph, boolean[] visited, 
                              int currentPos, int n, int count, int cost, int minimumCost) {
        //here visited is 1D  
        visited[currentPos]=true;
        //we have visited all nodes and we have to go back to starting node
        if(count==n && graph[currentPos][0]>0){
            minimumCost=Math.min(minimumCost, cost+graph[currentPos][0]);
            return minimumCost;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i] && graph[currentPos][i]>0){
                minimumCost=TSPUtil(graph, visited, i, n, count+1, cost+graph[currentPos][i], minimumCost);

                //Draw tree of movement to understand better.
                //#region tree
                //           1
                //         / | \
                //        /  |  \
                //       /   |   \
                //      2    3    4							
                //     / \
                //    /   \
                //   3     4
                //   |
                //   |
                //   4
                //   |
                //   1
                //#endregion
                visited[i]=false; //BackTrakking
            }
            
        }
        
        return minimumCost;
    }
}