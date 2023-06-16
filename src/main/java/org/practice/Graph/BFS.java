package org.practice.Graph;

import java.util.LinkedList;
import java.util.Queue;
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

public class BFS{
    static class Graph{
        int V;
        LinkedList<Integer> [] adjList;
        Graph(int v){
            V=v;
            adjList= new LinkedList[v];
            for (int i = 0; i < V; i++) {
                adjList[i]= new LinkedList<>();
            }
        }   

        private void addEdge(int s, int d){
            this.adjList[s].add(d);
            //this.adjList[d].add(s);
        }
    

        private void BFSUtil(int s){
            Queue<Integer> Q= new LinkedList<>();
            Q.add(s);
            boolean []visited= new boolean[V];
            visited[s]=true;
            while(!Q.isEmpty()){
                int node=Q.poll();
                System.out.print(node+" "); 
                for (int neighbor : adjList[node]) {
                    if(!visited[neighbor]){
                        Q.add(neighbor);
                        visited[neighbor]=true;
                    }
                }                
            }
        }
    }

    public static void main(String[] args) {
        Graph g= new Graph(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        
        //BFS traversal from a given source
        g.BFSUtil(2);
    }
}
