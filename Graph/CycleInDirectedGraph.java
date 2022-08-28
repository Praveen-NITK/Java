package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        int[][] edges={{1,4},{2,4},{3,1},{3,2},{4,3}};
        boolean isCycle=isCycleExist(5,edges);
        System.out.println(isCycle);
    }

    private static boolean isCycleExist(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for (int j = 0; j <n ; j++) {
            adj.add(new ArrayList<>());
        }
        boolean []visited=new boolean[n];
        boolean []dfsVisited=new boolean[n];
        Arrays.fill(visited,false);
        for (int []edge:edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i])
                if(isCycleDFS(i,adj,visited,dfsVisited))
                    return true;
        }
        return false;
    }

    private static boolean isCycleDFS(int source, List<List<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
        visited[source]=true;
        dfsVisited[source]=true;
        for(int v: adj.get(source)){
            if(!visited[v]){
                if(isCycleDFS(v,adj,visited,dfsVisited))
                    return true;
            }
            else if(visited[v] && dfsVisited[v])
                return true;
        }
        dfsVisited[source]=false;
        return false;
    }
}
