//Construct a complete binary tree from array or Level Order
//https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
package org.practice.Tree;

public class CompleteFromArray{

    static class Node{
        int data;
        Node left, right;
        public Node(int d){
            data=d;
            left=right=null;
        }
    }

    static Node root;
    public static void main(String[] args) {
        int[] treeData = new int[]{10,12,15,25,30,36};

        root=new Node(treeData[0]);
        Node troot= completeTreeFromArray(treeData, root, 0, treeData.length-1);

        printInOrder(troot);
        System.out.println("");
        printPreOrder(troot);
    }

    private static void printInOrder(Node root) {
        if(root==null)
            return;
        printInOrder(root.left);
        System.out.print(" "+root.data);
        printInOrder(root.right);
    }

    private static void printPreOrder(Node root) {
        if(root==null)
            return;
        System.out.print(" "+root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private static Node completeTreeFromArray(int[] treeData, Node node, int start, int end) {
        if(start>=end)
            return node;
        int left=start*2+1;          
        if(left<=end)
            node.left=completeTreeFromArray(treeData,new Node(treeData[left]),left,end);        
        
        int right=start*2+2;   
        if(right<=end)  
            node.right= completeTreeFromArray(treeData,new Node(treeData[right]),right,end);
        
        return node;
    }
}