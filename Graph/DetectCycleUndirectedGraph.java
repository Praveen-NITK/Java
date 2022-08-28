package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/redundant-connection/discuss/2403655/SIMPLE-USING-UNDIRECTED-CYCLE-DETECTION-METHOD
//https://leetcode.com/problems/redundant-connection/
public class DetectCycleUndirectedGraph {
    public static void main(String[] args) {
        int [][]edges={{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] result= detectEdgeCreatingCycle(edges);
        System.out.println(Arrays.toString(result));
    }

    private static int[] detectEdgeCreatingCycle(int[][] edges) {
        if(edges.length == 0)return new int[]{0,0};
        int n = edges.length+1;
        List<List<Integer>> adj= new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] visit = new boolean[n];
        int[] res=new int[2];
        for(int[] edge:edges){
            Arrays.fill(visit,false);
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            if(isCycleDfs(adj,visit,edge[0],-1)){
                return edge;
            }
        }
        return res;
    }

    // There is a cycle in a graph only if there is a back edge present in the graph.
    // A back edge is an edge that is joining a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
    private static boolean isCycleDfs(List<List<Integer>> adj, boolean[] visit, int source, int parent) {
        if (visit[source]) return true;
        visit[source]=true;
        for (int i: adj.get(source)) {
            if (parent!=i && isCycleDfs(adj,visit,i,source))
                return true;
        }
        return false;
    }
}
