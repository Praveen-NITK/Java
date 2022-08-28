package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MInHeightNodes {
    public static void main(String[] args) {
        int [][]graph={{3,0},{3,1},{3,2},{3,4},{5,4}};
        int []minHeightNodes=getMinHeightNode(graph,graph.length+1);
        System.out.println(Arrays.toString(minHeightNodes));
        List<List<Integer>> adj=new ArrayList<>();
        for (int [] edge:graph) {
            adj.add(new ArrayList<>());
        }
    }

    private static int[] getMinHeightNode(int[][] graph, int n) {
        return graph[0];
    }
}
