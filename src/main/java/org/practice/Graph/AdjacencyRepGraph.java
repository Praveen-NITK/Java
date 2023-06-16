package org.practice.Graph;

import java.util.LinkedList;

public class AdjacencyRepGraph{
    static class Graph{
        int V;
        LinkedList<Integer> adjacencyList[];
        Graph(int v){
            V=v;
            adjacencyList=new LinkedList[v];
            for(int i=0;i<v;i++){
                adjacencyList[i]=new LinkedList<>();
            }
        }
    }

    private static void addEdge(Graph g, int src, int dest ){
        g.adjacencyList[src].add(dest);
        g.adjacencyList[dest].add(src);
    }

    private static void printEdges(Graph g){
        for (LinkedList<Integer> var : g.adjacencyList) {
            System.out.println("----");
            for (Integer node : var) {
                System.out.println(node);
                
            }
        }
    }

    public static void main(String[] args) {
        int V=8;
        Graph graph= new Graph(V);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 0);
        addEdge(graph, 0, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 7);
        addEdge(graph, 4, 7);
        addEdge(graph, 4, 5);
        addEdge(graph, 4, 6);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 7);

        printEdges(graph);
    }    
}
