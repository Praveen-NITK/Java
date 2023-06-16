package org.practice.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BFSApplication{
    public static void main(String[] args) {
        //Graph link https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
       // https://www.geeksforgeeks.org/minimum-number-of-edges-between-two-vertices-of-a-graph/
        int arr[][]=new int[][]{{0,1,0,1,0,0,0,0},
                                {1,0,1,0,0,0,0,0},
                                {0,1,0,0,0,0,0,0},
                                {1,0,0,0,1,0,0,1},
                                {0,0,0,1,0,1,1,1},
                                {0,0,0,0,1,0,1,0},
                                {0,0,0,0,1,1,0,1},
                                {0,0,0,1,1,0,1,0}};


//        BFSTraversal(arr,2);  //2-->1-->0-->3-->4-->7-->5-->6
        printShortestPath(arr,0,7);
        //int minNodeCount=minNumberOfNodes(arr,2,6);
        //System.out.println("minNodeCount "+minNodeCount);
    }
    
    private static void BFSTraversal(int[][] graph, int src){
        boolean []visited= new boolean[8];
        Arrays.fill(visited, false);

        Queue Q=new LinkedList<Integer>();
        Q.add(src);
        visited[src]=true;
        //System.out.print(src);
        while(!Q.isEmpty()){
            int front= Integer.parseInt(Q.poll().toString());
            System.out.print("-->" + front);
            for(int i=0;i<graph.length;i++){
                if(graph[front][i]==1){
                    if(visited[i]==true)
                        continue;
                    //System.out.print("-->" + i);
                    Q.add(i);
                    visited[i]=true;
                }
            }
            

        }
    }

    private static int minNumberOfNodes(int[][] arr, int src, int dest) {
        int distance[]=new int [8];
        Arrays.fill(distance,0);

        boolean []visited = new boolean[8];
        Arrays.fill(visited, false);

        Queue queue= new LinkedList<Integer>();
        queue.add(src);
        visited[src]=true;

        while(!queue.isEmpty()){
            int front= Integer.parseInt(queue.poll().toString());
            for(int i=0;i<arr.length;i++){
                if(arr[front][i]==1 )
                { 
                    if(visited[i]==true){
                        continue;
                    }
                    
                    distance[i]=distance[front]+1;
                    queue.add(i);
                    visited[i]=true;                                        
                }
            }
        }
        
        return distance[dest];
    }



    private static void printShortestPath(int[][] arr, int src, int dest) {
        Queue<Integer> neib=new LinkedList<>();
        int predecessorNode[]=new int[8];
        Arrays.fill(predecessorNode, -1);
        
        boolean visited[]=new boolean[8];
        Arrays.fill(visited, false);

        visited[src]=true;

        if(arr[src][dest]==1){
            System.out.println(dest);
            return;
        }
        while(arr[src][dest]!=1){
            for(int i=0;i<8;i++){
                if(arr[src][i]==1 && !visited[i]){
                    predecessorNode[i]=src;
                    visited[i]=true;
                    src=i;
                    //neib.add(i);
                
                }else if(i==7){
                    src=predecessorNode[src];
                }
            }
        }
        if(!neib.isEmpty()){
            printShortestPath(arr, src, dest);
        }
        else{
            printShortestPath(arr, src, dest);
        }
    }

   
}
