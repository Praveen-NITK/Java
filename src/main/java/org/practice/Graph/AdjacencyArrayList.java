package org.practice.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyArrayList {
    static class Graph{
        int V;
        ArrayList<Integer> []adjList;
        public Graph(int v){
            V=v;
            adjList=new ArrayList[V];
            for (int i = 0; i < v; i++) {
                adjList[i]=new ArrayList<>();
            }
        }
        public static void addEdge(Graph g,int source, int dest){
            g.adjList[source].add(dest);
            g.adjList[dest].add(source);
        }

        public static void main(String[] args) {
            int size=7;
            Graph g= new Graph(size);
            addEdge(g,0,1);
            addEdge(g,0,6);
            addEdge(g,1,3);
            addEdge(g,3,5);
            addEdge(g,2,3);
            addEdge(g,2,4);
            addEdge(g,2,6);


            traverseBFS(g);
            traverseDFS(g);
        }

        private static void traverseDFS(Graph g) {
            Stack<Integer> st=new Stack<>();
            boolean []visited= new boolean[g.V];
            st.push(0);
            while (!st.isEmpty()){
                int current= st.pop();
                if(!visited[current]){
                    System.out.print(current + " ");
                    for (int nb : g.adjList[current]) {
                        st.push(nb);
                    }
                }
                visited[current]=true;
            }
        }

        private static void traverseBFS(Graph g) {
            Queue<Integer> q= new LinkedList<>();
            boolean []visited= new boolean[g.V];
            q.add(0);
            while (!q.isEmpty()){
                int current=q.poll();
                if(!visited[current]) {
                    System.out.print(current + " ");
                    for (int nb : g.adjList[current]) {
                        q.add(nb);
                    }
                }
                visited[current]=true;
            }
        }

    }
}
