package org.practice.Graph;
//https://algorithms.tutorialhorizon.com/category/dynamic-programming/

import java.util.LinkedList;

public class AdjacencyListRepWtGraph{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            src=s;
            dest=d;
            wt=w;
        }
    }

    static class Graph{
        int V;
        LinkedList<Edge>[] adj;
        public Graph(int v){
            V=v;
            adj= new LinkedList[v];
            for (int i = 0; i <v; i++) {
                adj[i]=new LinkedList<>();
            }

        }
        public void addEdge(int s, int d, int w){
            this.adj[s].add(new Edge(s,d,w));
        }
    }

    public static void main(String[] args) {
        Graph g= new Graph(5);
        g.addEdge(1, 2, 10);
        g.addEdge(1, 3, 15);
        g.addEdge(1, 4, 20);
        g.addEdge(2, 1, 5);
        g.addEdge(2, 3, 9);
        g.addEdge(2, 4, 10);
        g.addEdge(3, 1, 6);
        g.addEdge(3, 2, 3);
        g.addEdge(3, 4, 12);
        g.addEdge(4, 1, 8);
        g.addEdge(4, 2, 8);
        g.addEdge(4, 3, 9);

        printGraph(g);

    }

    private static void printGraph(Graph g) {
        for (int i = 0; i < g.adj.length; i++) {
            for (int j = 0; j < g.adj[i].size(); j++) {
                System.out.println(i+"--"+g.adj[i].get(j).wt+"-->"+g.adj[i].get(j).dest);
            }
        }
    }
}
