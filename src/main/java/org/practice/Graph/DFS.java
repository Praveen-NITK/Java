package org.practice.Graph;

import java.util.LinkedList;
import java.util.Stack;

//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
public class DFS{
    static class Graph{
        int V;
        LinkedList<Integer> []adj;
        Graph(int v){
            V=v;
            adj= new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i]=new LinkedList<>();
            }
        }

        void addEdge(int s, int d){
            adj[s].add(d);
        }

        public void DFSUtil(int s) {
            Stack<Integer> st= new Stack<>();
            st.push(s);
            boolean []visited= new boolean[V];
            
            visited[s]=true;
            while(!st.isEmpty()){
                int node= st.pop();
                System.out.println(node);
                for (int neighbour : adj[node]) {
                    if(!visited[neighbour]){
                        st.add(neighbour);
                        visited[neighbour]=true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 0);
        
        //DFS traversal from a given source
        g.DFSUtil(2);
    }
}
