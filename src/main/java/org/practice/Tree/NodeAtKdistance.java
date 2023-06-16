//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
package org.practice.Tree;
public class NodeAtKdistance{
    static class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }
    public static void main(String[] args) {
        int distance=3;
        int targetNode=70;
        Node root= new Node(50);
        root.left= new Node(30);
        root.right= new Node(70);
        root.left.left=new Node(20);
        root.left.right= new Node(40);
        root.right.left=new Node(60);
        root.right.right= new Node(80);
        root.left.left.left= new Node(10);
        root.right.right.right= new Node(100);

        //printNodeAtKdistanceFromThisRoot(root,distance);
        
        printNodeAtKdistance(root,targetNode,distance);        
    }

    private static int printNodeAtKdistance(Node root,int target, int distance) {
        if(root==null)
            return -1;
        if(root.data==target){
            printNodeAtKdistanceFromThisRoot(root, distance);
            return 0;
        }
        int ld= printNodeAtKdistance(root.left, target, distance-1);
        if(ld!=-1){
            
            if(ld+1==distance){
                System.out.println(root.data);
            }
            else
                printNodeAtKdistanceFromThisRoot(root.right, distance-ld-2);

            return ld+1;
        }

        int rd= printNodeAtKdistance(root.right, target, distance-1);
        if(rd!=-1){
            
            if(rd+1==distance){
                System.out.println(root.data);
            }
            else
                printNodeAtKdistanceFromThisRoot(root.left, distance-rd-2);

            return rd+1;
        }
        return -1;

    }

    private static void printNodeAtKdistanceFromThisRoot(Node root, int k) {
        if(root==null || k<0 )
            return;
        if(k==0){
            System.out.println(root.data);
            return;
        }
        printNodeAtKdistanceFromThisRoot(root.left, k-1);
        printNodeAtKdistanceFromThisRoot(root.right, k-1);

    }
}