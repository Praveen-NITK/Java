package Graph;

import java.util.LinkedList;
//https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
public class ConnectedComponents{
    static class Graph{
        int V;
        LinkedList<Integer>[] adjacencyList;
        Graph(int v){
            V=v;
            adjacencyList= new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjacencyList[i]=new LinkedList<>();                
            }
        }
    }

    private static void addEdge(int src, int dest, Graph g){
        g.adjacencyList[src].add(dest);
        g.adjacencyList[dest].add(src);
    }


    public static void main(String[] args) {
        Graph g= new Graph(8);
        addEdge(0, 1, g);
        addEdge(2, 0, g);
        addEdge(5, 2, g);
        addEdge(3, 4, g);
        addEdge(7, 4, g);

        getConnectedComponents(g);
    }

    private static void getConnectedComponents(Graph g) {
        boolean[] visited= new boolean[g.adjacencyList.length];

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){                
                DFSUtil(i, visited,g);
                System.out.println("");
            }
        }

    }

    private static void DFSUtil(int val, boolean[] visited, Graph g) {
        visited[val]=true;
        System.out.print(val+" ");
        for (int i : g.adjacencyList[val]) {
            if(!visited[i])
                DFSUtil(i, visited, g);
        }
    }
}