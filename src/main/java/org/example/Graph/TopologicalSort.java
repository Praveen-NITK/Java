//https://www.geeksforgeeks.org/topological-sorting/
package Graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        public Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int d) {
            this.adj[s].add(d);
        }
    }

    static Graph g;
    static Stack<Integer> st = new Stack<>();
    static boolean[] visited = new boolean[6];

    private static void printTopologicalOrder(int i) {
        
        for (int b : g.adj[i]) {
            if (!visited[b]) {
                printTopologicalOrder(b);
            }
        }
        if(!visited[i]){
            visited[i] = true;
            st.push(i);
        }
    }

    public static void printStack() {
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) {
        g = new Graph(6);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(5, 2);
        //g.addEdge(0, 3);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        //g.addEdge(3, 4);

        for (int i = 0; i < g.adj.length; i++) {
            printTopologicalOrder(i);
        }

        printStack();

    }

}